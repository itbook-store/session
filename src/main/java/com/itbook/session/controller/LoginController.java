package com.itbook.session.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 이하늬
 * @since 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping
    public String getLoginForm() {
        return "login";
    }

    @PostMapping
    public String doLogin(HttpServletRequest request,
                          @RequestParam String username, @RequestParam String pwd) {

        HttpSession session = request.getSession(false);
        redisTemplate.opsForHash().put(session.getId(), "username", username);
        session.setAttribute("username", username);

        return null;
    }
}
