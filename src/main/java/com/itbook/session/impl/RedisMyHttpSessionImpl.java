package com.itbook.session.impl;

import com.itbook.session.MyHttpSession;
import com.itbook.session.ThreadLocalManager;
import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 이하늬
 * @since 1.0
 */
@Component
public class RedisMyHttpSessionImpl implements MyHttpSession, Serializable {

    private long creationTime;
    private long lastAccessedTime;
    private int maxInactiveInterval;
    private boolean isNew;
    private RedisTemplate redisTemplate;


    public RedisMyHttpSessionImpl() {
        this.creationTime = System.currentTimeMillis();
        this.lastAccessedTime = System.currentTimeMillis();
//        this.maxInactiveInterval = ;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public String getId() {
        return ThreadLocalManager.getSessionId();
    }

    @Override
    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    @Override
    public void setMaxInactiveInterval(int var1) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return this.maxInactiveInterval;
    }

    @Override
    public Object getAttribute(String var1) {
        return ThreadLocalManager.getSessionId();
    }

    @Override
    public void setAttribute(String key, Object value) {
        redisTemplate.opsForSet().add(ThreadLocalManager.getSessionId(), key, value);
    }

    @Override
    public void removeAttribute(String var1) {
    }

    @Override
    public void invalidate() {
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
