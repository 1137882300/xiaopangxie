package com.xiaohei.repository.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by cc on 2022/7/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskPageQuery {

    /**
     * 任务类型
     */
    private Integer type;

    private String taskName;
    /**
     * [1:失效，0:有效]
     */
    private Integer status;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    private Long current;

    private Long size;

}
