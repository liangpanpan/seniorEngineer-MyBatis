package com.pp.test;

import com.alibaba.fastjson.JSON;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * 使用Java读取硬件CPU信息
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/11/25       create this file
 * </pre>
 */
public class CpuTest {

    public static void main(String[] args) {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        String toJSONString = JSON.toJSONString(operatingSystemMXBean);
        System.out.println(toJSONString);
    }
}
