package org.example.ai.exception;

/**
 * 异常处理工具类
 */
public class ThrowUtils {
    /**
     * 条件成立则抛出异常
     *
     * @param condition 条件
     * @param e         异常
     */
    public static void throwIf(boolean condition, RuntimeException e) {
        if (condition) {
            throw e;
        }
    }

    /**
     * 条件成立则抛出异常
     *
     * @param condition 条件
     * @param code      错误码
     */
    public static void throwIf(boolean condition, ErrorCode code) {
// 可直接复用上边的throwIf()
//        if (condition) {
//            throw new BusinessException(code);
//        }
        throwIf(condition, new BusinessException(code));
    }

    /**
     * 条件成立则抛出异常
     *
     * @param condition 条件
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
// 可直接复用上边的throwIf()
//        if (condition) {
//            throw new BusinessException(code);
//        }
        throwIf(condition, new BusinessException(errorCode, message));
    }
}
