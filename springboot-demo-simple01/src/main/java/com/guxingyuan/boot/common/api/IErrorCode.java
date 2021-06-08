package com.guxingyuan.boot.common.api;

/**
 * <pre>
 * @describe 封装API的错误码
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/16       create this file
 * </pre>
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
