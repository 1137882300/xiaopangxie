package com.xiaohei.common.model;

import java.io.Serializable;
import java.util.function.Supplier;
import javax.validation.constraints.NotNull;

import com.xiaohei.common.exception.BizException;
import lombok.*;
import org.slf4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class JsonResult<T> implements Serializable {
    public static final String SUCCESS_CODE = "200";
    public static final String ERROR_CODE = "500";
    public static final String RPC_ERROR_CODE = "RPC_ERROR";
    public static final String SUCCESS_MESSAGE = "操作成功!";
    public static final String RPC_ERROR = "系统繁忙,请稍后重试!";
    private static final long serialVersionUID = 1L;

    private String code;
    private Boolean success;
    private String message;
    private String appMessage;
    private T result;

    public JsonResult() {
        this(true, "200", "操作成功!");
    }

    public JsonResult(boolean isSuccess, String code, String message) {
        this.success = isSuccess;
        this.code = code;
        this.message = message;
    }

    public static <T> JsonResult<T> success() {
        return new JsonResult(true, "200", "操作成功!");
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> result = new JsonResult(true, "200", "操作成功!");
        result.setResult(data);
        return result;
    }

    public static <T> JsonResult<T> appMessageSuccess(T data, String appMessage) {
        return appMeassage(data, true, "200", "操作成功!", appMessage);
    }

    public static <T> JsonResult<T> appMeassage(T data, Boolean success, String code, String message, String appMessage) {
        JsonResult<T> result = new JsonResult(success, code, message);
        result.setAppMessage(appMessage);
        result.setResult(data);
        return result;
    }

    public static <T> JsonResult<T> error(String message) {
        return new JsonResult(false, "500", message);
    }

    public static <T> JsonResult<T> error(T data, String message) {
        JsonResult<T> result = new JsonResult(false, "500", message);
        result.setResult(data);
        return result;
    }

    public static <T> JsonResult<T> rpcError() {
        return new JsonResult(false, "RPC_ERROR", "系统繁忙,请稍后重试!");
    }

    public static <T> JsonResult<T> rpcError(String message) {
        return new JsonResult(false, "RPC_ERROR", message);
    }

    public static <T> JsonResult<T> error(String message, String code) {
        JsonResult<T> result = new JsonResult(false, code, message);
        result.setCode(code);
        return result;
    }

    public static JsonResult writeLog(Logger logger, String rpcErrorMessage, Object request, Throwable cause) {
        logger.error("rpcError," + rpcErrorMessage + ",request:{}", request, cause);
        return rpcError();
    }

    public static <T> T call(@NotNull Supplier<JsonResult<T>> supplier) {
        JsonResult<T> jsonResult = supplier.get();
        Assert.state(jsonResult.getSuccess(), "远程服务调用成功，服务执行失败: " + jsonResult.getMessage());
        return jsonResult.getResult();
    }

    public static <T> T callAndCheckNotNull(@NotNull Supplier<JsonResult<T>> supplier) {
        T t = call(supplier);
        Assert.notNull(t, "远程服务调用成功，返回结果为空");
        return t;
    }

    public void assertSuccess(String customMsg) {
        if (Boolean.FALSE.equals(this.success)) {
            throw new BizException(StringUtils.hasText(this.code) ? this.code : "500", StringUtils.hasText(customMsg) ? customMsg + ": " + this.message : this.message);
        }
    }

    public void assertSuccess() {
        this.assertSuccess((String) null);
    }


}
