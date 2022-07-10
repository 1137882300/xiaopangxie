package com.xiaohei.service.common.enums;

/**
 * Created by cc on 2022/7/10
 */
public enum StatusEnum {

    valid(0, "有效"),

    invalid(1, "失效");

    private int code;
    private String desc;


    StatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
