package com.lamaknyo.api.common.configs;

import com.lamaknyo.api.common.security.ClaimResult;
import com.lamaknyo.api.common.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean isRight = false;
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        if (request.getHeader("Authorization") != null) {
            String header = request.getHeader("Authorization").replaceAll("Bearer ", "");
            ClaimResult claimResult = jwtTokenProvider.validateToken(header);

            isRight = claimResult.isRight();
            request.setAttribute("isRight", isRight);

            if (isRight) {
                request.setAttribute("userId", claimResult.getClaimBody().getId());
            }
        } else {
            request.setAttribute("isRight", isRight);
            request.setAttribute("authErrorMessage", "No header Authorization");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("\nAuthInterceptor.postHandle::" + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime);
        System.out.println("\nAuthInterceptor.preHandle::" + request.getRequestURL() + ":: " + takenTime + "ms");
    }

}
