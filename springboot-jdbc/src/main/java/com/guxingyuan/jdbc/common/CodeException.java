package com.guxingyuan.jdbc.common;

import com.guxingyuan.jdbc.enumeration.ErrorCodeEnum;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/8/23       create this file
 * </pre>
 */
public class CodeException extends RuntimeException {

    private static final long serialVersionUID = -3214209717946191975L;

    ErrorCodeEnum errorCodeEnum;

    String message;

    /**
     * 生成错误异常
     *
     * @param errorCodeEnum 异常错误代码枚举
     */
    public CodeException(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
        this.message = errorCodeEnum.getErrorMessage();
    }

    /**
     * 生成异常消息中含有变量的Error
     *
     * @param errorCodeEnum 异常code代码枚举
     * @param args          需要往message中填充值的内容
     */
    public CodeException(ErrorCodeEnum errorCodeEnum, Object... args) {
        this.errorCodeEnum = errorCodeEnum;
        this.message = errorCodeEnum.getErrorMessage(args);
    }

    public CodeException(ErrorCodeEnum errorCodeEnum, String message, Throwable cause) {
        super(message, cause);
        this.errorCodeEnum = errorCodeEnum;
    }


    public String getErrorCode() {
        return errorCodeEnum.getErrorCode();
    }

    public String getMessage() {
        return message;
    }

}

