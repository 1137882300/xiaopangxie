package com.xiaohei.api.request;

import com.xiaohei.api.enums.TaskErrorEnum;
import com.xiaohei.common.exception.BizException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * Created by cc on 2022/7/16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditTaskRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long taskId;

    private Long Integral = 10L;

    private String content;
    /**
     * 任务状态：有效（true）失效（false）
     */
    private Boolean status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Map<String, String> extendMap;

    private Long modifier;

    private Long version;


    public void validRequest() {
        if (Objects.nonNull(startTime) && Objects.nonNull(endTime)) {
            if (endTime.isBefore(startTime)) {
                throw new BizException(TaskErrorEnum.TASK_TIME_ERROR);
            }
        }
        if (Objects.isNull(taskId)) {
            throw new BizException(TaskErrorEnum.TASK_ID_NOT_EMPTY);
        }
    }

}
