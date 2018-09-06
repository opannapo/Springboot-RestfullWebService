package com.lamaknyo.api.controller;

import com.lamaknyo.api.common.UrlComponent;
import com.lamaknyo.api.common.security.JwtTokenProvider;
import com.lamaknyo.api.common.security.Md5;
import com.lamaknyo.api.domain.AuthEntity;
import com.lamaknyo.api.domain.UsersEntity;
import com.lamaknyo.api.common.restemplate.Res;
import com.lamaknyo.api.common.FilterDto;
import com.lamaknyo.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController extends BaseRestController {
    @Autowired UserService service;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @GetMapping(UrlComponent.User.user)
    public Res user(@RequestParam(value = "id") int id) {
        FilterDto<String, Object> filterDto = new FilterDto<>();
        filterDto.put("id", id);
        return outOk(service.user(filterDto));
    }


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
}