package com.itbook.session.mysql.impl;

import com.itbook.session.MyHttpSession;
import com.itbook.session.ThreadLocalManager;
import com.itbook.session.mysql.entity.MySession;
import com.itbook.session.mysql.repository.MySessionRepository;
import java.io.Serializable;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author 노수연
 * @since 1.0
 */
@Component
@Primary
@RequiredArgsConstructor
public class MysqlMyHttpSessionImpl implements MyHttpSession, Serializable {

    private long creationTime = System.currentTimeMillis();
    private long lastAccessedTime = System.currentTimeMillis();
    private int maxInactiveInterval;
    private boolean isNew;

    private final MySessionRepository mySessionRepository;

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
    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    @Override
    public int getMaxInactiveInterval() {
        return this.maxInactiveInterval;
    }

    @Override
    public Object getAttribute(String key) {

        if(Objects.isNull(mySessionRepository.findBySessionId(key))) {
            return null;
        }

        return mySessionRepository.findBySessionId(key).getSessionId();
    }

    @Override
    public void setAttribute(String key, Object value) {

        if(Objects.nonNull(this.getAttribute(key))) {
            this.removeAttribute(key);
        }

        MySession mySession = new MySession(key, (String) value, creationTime, lastAccessedTime);
        mySessionRepository.save(mySession);

    }

    @Override
    public void removeAttribute(String key) {
        mySessionRepository.deleteBySessionId(key);
    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
