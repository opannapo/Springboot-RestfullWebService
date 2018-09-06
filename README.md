# Springboot-RestfullWebService
Example Project

# Point
- JWT Auth
- Interceptor
- JPA (JpaRepository , JpaSpecificationExecutor , Pagination)
- Query with Specification, Predicate, Eliminate Query to some related entity.
- Custom Exception
- ControllerAdvice -> ExceptionHandler (All Error types) 
- Response Template
- Etc...

 
### Dependencies used by Berok
| Point | Description |
| ------ | ------ |
| JWT Auth | Verifikasi JWT
|  | Expired, etc...
| Interceptor | AuthInterceptor extends HandlerInterceptorAdapter
|  | Berperan sebagai Middleware / Block request sebelum diteruskan ke Controller lalu mengembalikan nilai tertentu pada Controller yang dituju.
|  | Url terkait interceptor ini diregistrasikan pada AppConfiguration
| JPA | Specification & JpaSpecificationExecutor
|  | Dioperasikan sama seperti Eloquent
|  | Specification sebagai media untuk kondisi beberapa relasi yang saling berelasi dalam sebuah model
|  | Membatasi query ke beberapa relasi entity selama tidak diperlukan. Saya tidak tau pasti mengenai ini. Sebatas ini hanya mengacu pada LOG Query yang dieksekusi. Saya menemukan bahwa dalam sebuah entity yang memiliki beberapa relasi dengan entity lain, berhasil tidak dieksekusi oleh hibernate (Acuan Query LOG -> JDBC statements).
| Custom Exception | AuthException diThrow pada helper yang berperan dalam menangani verifikasi JWT
| ControllerAdvice | ExceptionHandler, menjadikan semua status response tetap 200. Tapi dengan menampilkan keterangan status aslinya beserta message dalam sebuah ResponseTemplate.
| Response Template | Konsisten dengan satu Pattern.
|  | data (Object) -> list/object
|  | error (Object) 
|  | success (boolean)






# How it's work

### 1. JWT Auth 
>User Auth

```UserController
...
@PostMapping(UrlComponent.User.user_auth)
public Res auth(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
    FilterDto<String, Object> filterDto = new FilterDto<>();
    filterDto.put("username", username);
    filterDto.put("password", Md5.generate(password));

    UsersEntity user = service.auth(filterDto);
    System.out.print("USER USER USER " + user);
    if (user != null) {
        user.setToken(jwtTokenProvider.generateToken(user));
        AuthEntity authEntity = new AuthEntity();
        authEntity.setToken(user.getToken());
        authEntity.setUsername(user.getUsername());
        return outOk(authEntity);
    } else {
        return outFail("User Not Found", 200);
    }
}
...
```

>Verify
```UserController
...
@PostMapping(value = UrlComponent.User.user_edit_privacy_basic, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public Res userEditBasic(
        HttpServletRequest request,
        @RequestParam(value = "name") String name,
        @RequestParam(value = "phone") String phone,
        @RequestParam(value = "bio") String bio,
        @RequestParam(value = "gender") int gender) {

    if (request.getAttribute("isRight").equals(true)) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("userId", request.getAttribute("userId"));
        filterDto.put("name", name);
        filterDto.put("phone", phone);
        filterDto.put("bio", bio);
        filterDto.put("gender", gender);
        return outOk(service.updateBasic(filterDto));
    } else {
        return outFail(String.valueOf(request.getAttribute("authErrorMessage")), 404);
    }
}
... 
```
>Parsing kembalian dari Interceptor -> (request.getAttribute("isRight").equals(true))
```MessageController
...
@GetMapping(UrlComponent.Message.messages_of_me)
public Res messageOfMe(
        HttpServletRequest request,
        @RequestParam(value = "page") int page,
        @RequestParam(value = "limit") int limit) {
    if (request.getAttribute("isRight").equals(true)) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("userId", request.getAttribute("userId"));
        return outOk(service.messageOfMe(filterDto, page, limit));
    } else {
        return outFail(String.valueOf(request.getAttribute("authErrorMessage")), 404);
    }
}
... 
```  



### 2. JPA (JpaRepository , JpaSpecificationExecutor , Pagination) 
>JpaRepository , JpaSpecificationExecutor
```ProductRepository
...
@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long>, JpaSpecificationExecutor<ProductsEntity> {
}
...
```

>Specification & Pagination
#One -> Product by Id, Kondisi -> Product:Status = Active & Seller:Status=Active
```ProductRepository
...
@Override
public Optional product(FilterDto filterDto) {
    Specification spec = (Specification) (root, query, builder) -> {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller");
        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(root.get("id"), filterDto.get("id")),
                builder.equal(seller.get("status"), 1)
        ).orderBy(builder.asc(root.get("id"))).distinct(true);
        return query.getGroupRestriction();
    };

    return repo.findOne(spec);
}
...
```

>Pagination -> Product[List] of Seller / Filter By Address Name , Kondisi -> Product:Status = Active & Seller:ID={Parameter} & Filter Text
```ProductRepository
...

//ProductOfSeller
@Override
public Page<ProductsEntity> productsOfSeller(FilterDto filterDto, int page, int limit) {
    Specification spec = (Specification) (root, query, builder) -> {
        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(root.get("sllrId"), filterDto.get("sellerId"))
        ).orderBy(builder.asc(root.get("id"))).distinct(true);

        return query.getGroupRestriction();
    };

    Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
    productsEntities.forEach(productsEntity -> productsEntity.setSeller(null));
    return productsEntities;
}
...
...
... 
//Filter by ProductTitle, AddressName, CityName, AreaName, ProvinceName
@Override
public Page<ProductsEntity> productsFilter(FilterDto filterDto, int page, int limit) {
    Specification spec = (Specification) (root, query, builder) -> {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller");
        Join<SellersEntity, AddressesEntity> addr = seller.join("address");
        Join<AddressesEntity, LocCitiesEntity> city = addr.join("city");
        Join<AddressesEntity, LocAreasEntity> area = addr.join("area");
        Join<AddressesEntity, LocProvincesEntity> province = addr.join("province");
        query.where(
                builder.equal(root.get("status"), 1),
                builder.like(root.get("title"), "%" + filterDto.get("name") + "%"),
                builder.or(
                        builder.like(addr.get("name"), "%" + filterDto.get("address") + "%"),
                        builder.like(city.get("name"), "%" + filterDto.get("address") + "%"),
                        builder.like(area.get("name"), "%" + filterDto.get("address") + "%"),
                        builder.like(province.get("name"), "%" + filterDto.get("address") + "%")
                )
        ).orderBy(builder.asc(root.get("id"))).distinct(true);
        return query.getGroupRestriction();
    };
 
    Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
    productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
    productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
    return productsEntities;
}
```



>Pagination & Limit Query to Related Entity -> Product[List] of Seller. Limit Query to SellerEntity, karna data Seller sudah tidak dibutuhkan pada Query ini.
```ProductRepository
...
...
@Override
public Page<ProductsEntity> productsOfSeller(FilterDto filterDto, int page, int limit) {
    Specification spec = (Specification) (root, query, builder) -> {
        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(root.get("sllrId"), filterDto.get("sellerId"))
        ).orderBy(builder.asc(root.get("id"))).distinct(true);

        return query.getGroupRestriction();
    };

    Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
    productsEntities.forEach(productsEntity -> productsEntity.setSeller(null));
    return productsEntities;
}
...  
```


>Pagination & Limit Query to Related Entity -> Product[List] of Categories. Limit Query to CategoryEntity,Seller->ShimpentEntity,Seller->AddressEntity, karna data Category sudah tidak dibutuhkan pada Query ini. Dan data Seller yang dibutuhkan hanya data basic, tidak membutuhkan Address dan Shimpent.
```ProductRepository
...
@Override
public Page<ProductsEntity> productsOfCategory(FilterDto filterDto, int page, int limit) {
    Specification spec = (Specification) (root, query, builder) -> {
        Join<ProductsEntity, SellersEntity> seller = root.join("seller", JoinType.INNER);
        query.where(
                builder.equal(root.get("status"), 1),
                builder.equal(root.get("catId"), filterDto.get("catId")),
                builder.equal(seller.get("status"), 1)
        ).orderBy(builder.asc(root.get("id"))).distinct(true);

        return query.getGroupRestriction();
    };

    Page<ProductsEntity> productsEntities = repo.findAll(spec, PageRequest.of(page - 1, limit));
    productsEntities.forEach(productsEntity -> productsEntity.setCategory(null));
    productsEntities.forEach(productsEntity -> productsEntity.getSeller().setSellerShipment(null));
    productsEntities.forEach(productsEntity -> productsEntity.getSeller().setAddress(null));
    return productsEntities;
}
...  
```
