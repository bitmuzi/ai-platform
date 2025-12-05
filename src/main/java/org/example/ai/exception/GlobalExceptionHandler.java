package org.example.ai.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.example.ai.common.BaseResponse;
import org.example.ai.common.ResultUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Hidden // 加入@Hidden可以解决SpringBoot3.4后knief4j扫到@RestControllerAdvice报错问题
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 环绕切面, 在捕获到BusinessException.class异常时会进入下面的处理流程
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    // 用于接收上面未捕获到的异常
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> businessExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}
