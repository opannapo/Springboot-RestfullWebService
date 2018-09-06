package com.lamaknyo.api.common.configs;

import com.lamaknyo.api.common.UrlComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfiguration implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns(pathPatterns());
    }

    private List<String> pathPatterns() {
        List<String> patterns = new ArrayList<>();
        patterns.add(UrlComponent.Message.messages_of_me);
        patterns.add(UrlComponent.User.user_signout);
        patterns.add(UrlComponent.User.user_edit_privacy_email);
        patterns.add(UrlComponent.User.user_edit_privacy_password);
        patterns.add(UrlComponent.User.user_edit_privacy_photo);
        patterns.add(UrlComponent.User.user_edit_privacy_address);
        patterns.add(UrlComponent.User.user_edit_privacy_basic);
        return patterns;
    }

}
