package com.xiaohei.service.common.enums;

/**
 * Created by cc on 2022/7/16
 */
public enum RelationTypeEnum {

    /**
     * 任务和人的关系
     * - 领取任务
     * - 拒绝任务
     */
    task_human("task_human"),
    gift_integral("gift_integral"),
    ;

    private String code;

    RelationTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
