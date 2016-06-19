package com.nxy.spider.except;

public class AppRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -5709759775022172059L;

    /**
     * 构造函数
     */
    public AppRuntimeException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message
     */
    public AppRuntimeException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param message
     * @param cause
     */
    public AppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param cause
     */
    public AppRuntimeException(Throwable cause) {
        super(cause);
    }
}
