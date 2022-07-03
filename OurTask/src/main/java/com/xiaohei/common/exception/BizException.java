package com.xiaohei.common.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by cc on 2022/7/3
 */
public class BizException extends RuntimeException {

    private static final String ATTR_CODE = "errorCode";
    private static final String ATTR_DESC = "errorDesc";
    private static final String ATTR_CLASS = "className";

    public BizException(BaseErrorEnum baseErrorEnum) {
        super(
                (new JSONObject()).fluentPut("errorCode", baseErrorEnum.getCode())
                        .fluentPut("errorDesc", baseErrorEnum.getMessage())
                        .fluentPut("className", BizException.class.getName())
                        .toJSONString()
        );
    }

    public <T> BizException(T errorCode, String message) {
        super(
                (new JSONObject()).fluentPut("errorCode", errorCode)
                        .fluentPut("errorDesc", message)
                        .fluentPut("className", BizException.class.getName())
                        .toJSONString()
        );
    }

    public BizException(BaseErrorEnum baseErrorEnum, Throwable cause) {
        super(
                (new JSONObject()).fluentPut("errorCode", baseErrorEnum.getCode())
                        .fluentPut("errorDesc", baseErrorEnum.getMessage())
                        .fluentPut("className", BizException.class.getName())
                        .toJSONString(), cause
        );
    }

    public String extractCode() {
        return JSON.parseObject(super.getMessage()).getString("errorCode");
    }

    public String extractMessage() {
        return JSON.parseObject(super.getMessage()).getString("errorDesc");
    }
}
