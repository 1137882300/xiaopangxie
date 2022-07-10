package com.xiaohei.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cc on 2022/7/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryRequest {

    private Long current = 1L;

    private Long size = 10L;

}
