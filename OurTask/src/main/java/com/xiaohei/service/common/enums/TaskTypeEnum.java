package com.xiaohei.service.common.enums;

import java.util.Objects;

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

    public static TaskTypeEnum getByCode(Integer code) {
        if (Objects.nonNull(code)) {
            for (TaskTypeEnum value : TaskTypeEnum.values()) {
                if (code == value.code) {
                    return value;
                }
            }
        }
        return TaskTypeEnum.ordinary;
    }


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
