package com.itbook.session;

/**
 * @author 이하늬
 * @since 1.0
 */
public interface MyHttpSession {
    long getCreationTime(); //세션이 생성된 시간을 January 1 ,1970 GMT 부터 long 형 밀리세컨드 값으로 반환

    String getId(); //세션 고유 ID

    long getLastAccessedTime();  //웹 브라우저의 요청이 마지막으로 시도된 시간을 long 형 ms 값으로 반환

    void setMaxInactiveInterval(int var1);  //세션을 유지할 시간을 초단위로 설정 합니다.

    int getMaxInactiveInterval(); // 세션의 유효시간을 초 단위로 반환 합니다. 기본값은 30초 입니다.

    Object getAttribute(String key); //get attribute

    void setAttribute(String key, Object value); //attribute 설정

    void removeAttribute(String key); //attribte 삭제

    void invalidate(); //현재 세션을 종료. 세션관련 모든 값 삭제

    boolean isNew(); //session이 만들어졌는지 boolean 타입으로 반환 합니다.
}
