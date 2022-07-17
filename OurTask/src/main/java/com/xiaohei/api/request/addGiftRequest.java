package com.xiaohei.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by cc on 2022/7/17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class addGiftRequest implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer type;

    private String describe;


}
