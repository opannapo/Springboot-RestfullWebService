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
|  | Berperan sebagai Middleware / Block request sebelum diteruskan ke Controller
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
