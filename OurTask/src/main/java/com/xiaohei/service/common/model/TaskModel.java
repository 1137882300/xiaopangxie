package com.xiaohei.service.common.model;

import com.xiaohei.service.common.enums.TaskTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by cc on 2022/7/10
 */
@Data
public class TaskModel {

    private Long taskId;

    private TaskTypeEnum type;

    private String content;

    private Long creator;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long version;

    private Long updateTime;

    private Long createTime;

}
