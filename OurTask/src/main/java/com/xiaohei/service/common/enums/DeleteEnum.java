package com.xiaohei.service.common.enums;

/**
 * Created by cc on 2022/7/10
 */
public enum DeleteEnum {

    undelete(0, "未删"),

    deleted(1, "已删");

    private int code;
    private String desc;


    DeleteEnum(int code, String desc) {
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
