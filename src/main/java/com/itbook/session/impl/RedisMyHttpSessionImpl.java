package com.itbook.session.impl;

import com.itbook.session.MyHttpSession;
import com.itbook.session.ThreadLocalManager;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 이하늬
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class RedisMyHttpSessionImpl implements MyHttpSession, Serializable {

    private long creationTime = System.currentTimeMillis();
    private long lastAccessedTime;
    private int maxInactiveInterval;
    private boolean isNew = false;
    private final RedisTemplate<String, Object> redisTemplate;


    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public String getId() {
        lastAccessedTime = System.currentTimeMillis();
        return ThreadLocalManager.getSessionId();
    }

    @Override
    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
        this.maxInactiveInterval = interval;
    }

    @Override
    public int getMaxInactiveInterval() {
        return this.maxInactiveInterval;
    }

    @Override
    public Object getAttribute(String var1) {
        lastAccessedTime = System.currentTimeMillis();
        return ThreadLocalManager.getSessionId();
    }

    @Override
    public void setAttribute(String key, Object value) {
        lastAccessedTime = System.currentTimeMillis();
        redisTemplate.opsForHash().put(ThreadLocalManager.getSessionId(), key, value);
    }

    @Override
    public void removeAttribute(String key) {
        lastAccessedTime = System.currentTimeMillis();
        redisTemplate.delete(key);
    }

    @Override
    public void invalidate() {
        this.removeAttribute(ThreadLocalManager.getSessionId());
        ThreadLocalManager.removeSessionId();
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
