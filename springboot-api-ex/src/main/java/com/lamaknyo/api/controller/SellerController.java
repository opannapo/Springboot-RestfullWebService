package com.lamaknyo.api.controller;

import com.lamaknyo.api.common.UrlComponent;
import com.lamaknyo.api.common.restemplate.Res;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.SellerService;
import com.lamaknyo.api.services.SellerServiceGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SellerController extends BaseRestController {
    @Autowired SellerService service;
    //@Autowired SellerServiceGraph service;

    @GetMapping(UrlComponent.Seller.seller)
    public Res seller(@RequestParam(value = "id") int id) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("id", id);
        return outOk(service.seller(filterDto));
    }

    @GetMapping(UrlComponent.Seller.sellers_active)
    public Res sellerActive(
            @RequestHeader("Authorization") String auth,
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        return outOk(service.sellersActive(page, limit));
    }

    @GetMapping(UrlComponent.Seller.sellers_filter)
    public Res sellersFilter(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "name") String name) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("address", address);
        filterDto.put("name", name);
        return outOk(service.sellersFilter(filterDto, page, limit));
    }
}