package com.xiaohei.service.common;

/**
 * Created by cc on 2022/7/3
 */
public enum TaskTypeEnum {

    ordinary(1, "普通任务"),
    immediate(2, "即刻任务"),

    ;

    private int code;
    private String desc;

    TaskTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
