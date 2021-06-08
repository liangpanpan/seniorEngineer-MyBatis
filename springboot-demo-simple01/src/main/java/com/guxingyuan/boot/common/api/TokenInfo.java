package com.guxingyuan.boot.common.api;

import lombok.Data;

import java.util.Map;

/**
 * <pre>
 * @Describe 认证服务器返回的TokenInfo的封装
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/16       create this file
 * </pre>
 */
@Data
public class TokenInfo {

    private String access_token;

    private String token_type;

    private String refresh_token;

    private String scope;

    private Map<String, String> additionalInfo;

}
