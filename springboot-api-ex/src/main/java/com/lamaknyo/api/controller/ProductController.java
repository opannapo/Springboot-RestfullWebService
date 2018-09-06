package com.lamaknyo.api.controller;

import com.lamaknyo.api.common.UrlComponent;
import com.lamaknyo.api.common.restemplate.Res;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends BaseRestController implements UrlComponent {
    @Autowired ProductService service;
    private final int PRODUCT_TOP_LIMIT = 10;

    @GetMapping(Product.product)
    public Res product(@RequestParam("id") long prdId) {

        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("id", prdId);
        return outOk(service.product(filterDto));
    }

    @GetMapping(Product.products_active)
    public Res productsActive(@RequestParam("page") int page,
                              @RequestParam("limit") int limit) {
        return outOk(service.productsActive(page, limit));
    }

    @GetMapping(Product.products_filter)
    public Res productsFilter(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "name") String name) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("address", address);
        filterDto.put("name", name);
        return outOk(service.productsFilter(filterDto, page, limit));
    }

    @GetMapping(Product.products_of_seller)
    public Res productsOfSeller(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "sellerId") int sellerId) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("sellerId", sellerId);
        return outOk(service.productsOfSeller(filterDto, page, limit));
    }

    @GetMapping(Product.products_of_category)
    public Res productsOfCategory(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "catId") int catId) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("catId", catId);
        return outOk(service.productsOfCategory(filterDto, page, limit));
    }

    @GetMapping(Product.products_exclusive)
    public Res productsExclusive(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit) {
        return outOk(service.productsExclusive(page, limit));
    }

    @GetMapping(Product.products_promotion)
    public Res productsPromotion(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit) {
        return outOk(service.productsPromotion(page, limit));
    }

    @GetMapping(Product.products_top)
    public Res productsTop() {
        return outOk(service.productsTop(1, PRODUCT_TOP_LIMIT));
    }
}