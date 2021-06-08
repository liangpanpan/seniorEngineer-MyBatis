package com.guxingyuan.boot.common.exception;

import com.guxingyuan.boot.common.api.IErrorCode;
import lombok.Data;

/**
 * <pre>
 * @Describe 网关异常类
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/16       create this file
 * </pre>
 */
@Data
public class GateWayException extends RuntimeException {

    private long code;

    private String message;

    public GateWayException(IErrorCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }
}
