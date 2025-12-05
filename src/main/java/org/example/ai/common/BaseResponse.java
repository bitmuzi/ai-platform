package org.example.ai.common;

import lombok.Data;
import org.example.ai.exception.ErrorCode;

import java.io.Serializable;

/**
 * 全局响应封装类
 * implements Serializable 表可支持序列化
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {
    private int code;
    private T data;
    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, "");
    }
}
