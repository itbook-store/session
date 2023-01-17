package com.itbook.session.impl;

import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * @author 이하늬
 * @since 1.0
 */
public class CustomHttpSession{

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    protected ConcurrentMap<String, Object> attributes = new ConcurrentHashMap<>();

    public CustomHttpSession() {
        threadLocal.set(UUID.randomUUID().toString());
    }
    public String getId() {
        return threadLocal.get();
    } //세션 고유 ID

    public void setAttribute(String var1, Object var2) {
        attributes.put(var1, var2);
    }

    public long getLastAccessedTime() {

    }  //웹 브라우저의 요청이 마지막으로 시도된 시간을 long 형 ms 값으로 반환

    public ServletContext getServletContext() {
        return null;
    }

    public void setMaxInactiveInterval(int var1) {

    }  //세션을 유지할 시간을 초단위로 설정 합니다.

    public int getMaxInactiveInterval() {

    } // 세션의 유효시간을 초 단위로 반환 합니다. 기본값은 30초 입니다.

}
