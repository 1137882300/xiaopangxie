package com.xiaohei.api.request;

import java.time.LocalDateTime;

/**
 * Created by cc on 2022/7/3
 */
public class TaskAddRequest {

    private Integer type;

    private String content;

    private Long creator;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
