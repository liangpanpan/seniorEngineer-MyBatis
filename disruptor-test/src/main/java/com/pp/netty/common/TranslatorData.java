package com.pp.netty.common;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
@Data
public class TranslatorData implements Serializable {
    private String id;

    private String name;

    private String message;
}

