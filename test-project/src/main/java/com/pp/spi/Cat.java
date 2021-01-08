package com.pp.spi;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/8       create this file
 * </pre>
 */
public class Cat implements Animal {
    @Override
    public void say() {
        System.out.println("miao miao miao");
    }
}
