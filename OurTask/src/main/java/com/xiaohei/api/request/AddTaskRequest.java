package com.xiaohei.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by cc on 2022/7/3
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 积分数量
     */
    @Size(min = 10, message = "最少是10积分")
    private Long Integral = 10L;

    private Integer type;

    private String content;

    private Long creator;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Map<String, String> extendMap;
}
