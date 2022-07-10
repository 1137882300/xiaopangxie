package com.xiaohei.api.vo;

import java.time.LocalDateTime;

/**
 * Created by cc on 2022/7/10
 */
public class TaskVO {

    private Long id;

    /**
     * 任务类型
     */
    private Integer type;

    private String taskName;

    /**
     * 任务内容
     */
    private String content;

    /**
     * [1:失效，0:有效]
     */
    private Integer status;

    /**
     * 预留拓展
     */
    private String features;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * [1:删除,0:未删除]
     */
    private Integer isDeleted;

}
