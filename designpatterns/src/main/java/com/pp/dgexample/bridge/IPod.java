package com.pp.dgexample.bridge;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class IPod extends Product {

    public void beProducted() {
        System.out.println("生产出的iPod是这样的...");
    }

    public void beSelled() {
        System.out.println("生产出的iPod卖出去了...");
    }
}
