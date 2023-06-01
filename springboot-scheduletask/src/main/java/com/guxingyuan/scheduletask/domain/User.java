package com.guxingyuan.scheduletask.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/1       create this file
 * </pre>
 */
@Data
@ToString
public class User implements Serializable {

    private String userId;

    private String userName;

    private String age;

    private String info;

    private Integer number = 1;

}
