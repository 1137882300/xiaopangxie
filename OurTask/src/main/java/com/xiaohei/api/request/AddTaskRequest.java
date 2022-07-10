package com.xiaohei.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by cc on 2022/7/3
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest {

    private Integer type;

    private String content;

    private Long creator;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Map<String, String> extendMap;
}
