package com.itbook.session.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        Cookie cookie = request.getCookies()

        if (itbook == null) {
            response.sendRedirect("/login");
            return false;
        }

        response.sendRedirect("/login/success");
        return true;
    }

}


