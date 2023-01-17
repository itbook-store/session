package com.itbook.session.mysql.repository;

import com.itbook.session.mysql.entity.MySession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 노수연
 * @since 1.0
 */
public interface MySessionRepository extends JpaRepository<MySession, String> {
    MySession findBySessionId(String sessionId);

    @Transactional
    void deleteBySessionId(String sessionId);
}
