package com.itbook.session;

/**
 * @author 이하늬
 * @since 1.0
 */
public class ThreadLocalManager {
    public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void setSessionId(String sessionId) {
        THREAD_LOCAL.set(sessionId);
    }

    public static String getSessionId() {
        return THREAD_LOCAL.get();
    }

    public static void removeSessionId() {
        THREAD_LOCAL.remove();
    }
}
