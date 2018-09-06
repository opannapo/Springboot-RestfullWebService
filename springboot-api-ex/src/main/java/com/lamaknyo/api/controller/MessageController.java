package com.lamaknyo.api.controller;

import com.lamaknyo.api.common.UrlComponent;
import com.lamaknyo.api.common.restemplate.Res;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class MessageController extends BaseRestController {
    @Autowired MessageService service;

    @GetMapping(UrlComponent.Message.message)
    public Res message(@RequestParam(value = "id") int id) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("id", id);
        return outOk(service.message(filterDto));
    }

    @GetMapping(UrlComponent.Message.messages_of_user)
    public Res messageOfUser(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "userId") int userId) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("userId", userId);
        return outOk(service.messageOfUser(filterDto, page, limit));
    }

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
}