package com.xiaohei.api.enums;

import com.xiaohei.common.exception.BaseErrorEnum;

/**
 * Created by cc on 2022/7/16
 */
public enum TaskErrorEnum implements BaseErrorEnum {

    TASK_TIME_ERROR("时间错误"),
    TASK_ID_NOT_EMPTY("任务ID不能为空"),
    TASK_NOT_EXIST("任务不存在啊"),
    TASK_OPTIMISTIC_LOCKING_ERROR("版本号不对"),



    ;


    TaskErrorEnum(String message) {
        this.message = message;
    }

    private final String message;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }
}

