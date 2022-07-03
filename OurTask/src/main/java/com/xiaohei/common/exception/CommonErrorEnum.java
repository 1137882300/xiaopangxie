package com.xiaohei.common.exception;

/**
 * Created by cc on 2022/7/3
 */
public enum CommonErrorEnum implements BaseErrorEnum {
    ILLEGAL_ARGUMENT("参数不合法"),
    UNSUPPORTED("系统不支持");

    private final String message;

    CommonErrorEnum(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.name();
    }

    public String getMessage() {
        return this.message;
    }
}
