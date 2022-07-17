package com.xiaohei.api.request;

import com.xiaohei.api.enums.TaskErrorEnum;
import com.xiaohei.common.exception.BizException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by cc on 2022/7/16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveTaskRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long taskId;
    /**
     * 领取人
     */
    private Long recipient;
    /**
     * 1. 领取true
     * 2. 拒绝false
     */
    private Boolean receive = Boolean.TRUE;

    public void verifyRequest(){
        if (Objects.isNull(taskId) || Objects.isNull(recipient)){
            throw new BizException(TaskErrorEnum.TASK_AND_RECIPIENT_NOT_EMPTY);
        }
    }
}
