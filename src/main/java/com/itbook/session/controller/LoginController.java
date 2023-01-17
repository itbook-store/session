package com.itbook.session.controller;

import com.itbook.session.MyHttpSession;
import com.itbook.session.ThreadLocalManager;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author 이하늬
 * @since 1.0
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final RedisTemplate<String, String> redisTemplate;
    private final String username_itbook = "itbook";
    private final String pwd_itbook = "1234";
    @Qualifier("mysqlMyHttpSessionImpl")
    private final MyHttpSession myHttpSession;


    @GetMapping("/login")
    public String getLoginForm(@SessionAttribute(value = "itbook_session", required = false) String itbook_session) {
        if(!Objects.isNull(itbook_session)) {
            return "redirect:/";
        }
        return "view/loginForm";
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        String itbook_session = myHttpSession.getId();
        String id = (String) myHttpSession.getAttribute("id");
        if (!Objects.isNull(itbook_session)) {
            model.addAttribute("itbook_session", itbook_session);
            model.addAttribute("username", id);
        }

        return "view/index";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request,
                          @RequestParam String id, @RequestParam String pwd,
                          HttpServletResponse response) {

        if (id.equals(username_itbook) && pwd.equals(pwd_itbook)) {
            doLoginProcess(id, response);
            return "redirect:/";
        }
        return "redirect:/login";
    }

    private void doLoginProcess(String id, HttpServletResponse response) {

        String sessionId = UUID.randomUUID().toString();

        Cookie cookie = new Cookie("itbook_cookie", sessionId);
        ThreadLocalManager.setSessionId(sessionId);
        myHttpSession.setAttribute("id", id);
        response.addCookie(cookie);
    }

}
