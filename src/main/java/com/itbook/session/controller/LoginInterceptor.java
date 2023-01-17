package com.itbook.session.controller;

import com.itbook.session.ThreadLocalManager;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String itbookSessionId = null;

        if (!Objects.isNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("itbook_cookie")) {
                    itbookSessionId = cookie.getValue();
                }
            }
        }

        if (Objects.isNull(itbookSessionId)) {
            response.sendRedirect("/login");
            return false;
        }
        ThreadLocalManager.setSessionId(itbookSessionId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        ThreadLocalManager.removeSessionId();
    }
}
