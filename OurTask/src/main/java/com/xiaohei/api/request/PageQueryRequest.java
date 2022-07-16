package com.xiaohei.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by cc on 2022/7/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long current = 1L;

    private Long size = 10L;

}
