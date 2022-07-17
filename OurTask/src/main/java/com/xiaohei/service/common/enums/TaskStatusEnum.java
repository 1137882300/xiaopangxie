package com.xiaohei.service.common.enums;

/**
 * Created by cc on 2022/7/10
 */
public enum TaskStatusEnum {

    refused(0, "已拒绝"),
    received(1, "已领取"),
    completed(2, "已完成"),
    unfinished(3, "未完成"),

    ;

    private int code;
    private String desc;


    TaskStatusEnum(int code, String desc) {
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
