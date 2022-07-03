package com.xiaohei.common.exception;

/**
 * Created by cc on 2022/7/3
 */
public interface BaseErrorEnum {
    String getCode();

    String getMessage();

    default BaseErrorEnum of(String code, String message) {
        return new BaseErrorEnum() {
            public String getCode() {
                return code;
            }

            public String getMessage() {
                return message;
            }
        };
    }
}
