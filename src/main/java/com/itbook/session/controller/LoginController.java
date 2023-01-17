package com.itbook.session.controller;

import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 이하늬
 * @since 1.0
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {

    private final RedisTemplate<String, String> redisTemplate;
    private final String username_itbook = "itbook";
    private final String pwd_itbook = "1234";


    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping
    public String getIndex(HttpServletRequest request) {
        /*HttpSession session = request.getSession(false);

        String loginItbook = (String) session.getAttribute("loginItbook");

        System.out.println(">>>>> " + session.getAttribute("loginItbook") + " >>>>> ");
        if(Objects.nonNull(loginItbook)) {
            return "redirect:/login/success";
        }*/

        return "index";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request,
                          @RequestParam String username, @RequestParam String pwd,
                          HttpServletResponse response) {

        if (username.equals(username_itbook) && pwd.equals(pwd_itbook)) {

            Cookie cookie = new Cookie("itbook", String.valueOf(username_itbook));
            response.addCookie(cookie);

/*            HttpSession session = request.getSession(false);
            Cookie cookie = new Cookie("itbook-cookie", session.getId());
            response.addCookie(cookie);
            redisTemplate.opsForHash().put(session.getId(), "username", username);
            session.setAttribute(session.getId(), username);*/
        }
        return "redirect:/";
    }

    @GetMapping("/login/success")
    public String successLogin() {
        return "login_success";
    }

}
