package com.pp.dgexample.bridge;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public abstract class Product {
    //甭管是什么产品它总要能被生产出来
    public abstract void beProducted();

    //生产出来的东西，一定要销售出去，否则亏本
    public abstract void beSelled();
}
