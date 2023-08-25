package com.guxingyuan.jdbc.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/8/25       create this file
 * </pre>
 */
@ToString
@Data
public class Emp implements Serializable {

    private Integer id;

    private String userName;

}
