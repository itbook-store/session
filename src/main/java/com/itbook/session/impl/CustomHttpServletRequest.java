package com.itbook.session.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * @author 이하늬
 * @since 1.0
 */
public class CustomHttpServletRequest extends HttpServletRequestWrapper {


    public CustomHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public CustomHttpSession getSession() {
        return getSession(true);
    }

    public CustomHttpSession getSession(boolean createNew) {
        // create an HttpSession implementation from Spring Session
        return
    }

}
