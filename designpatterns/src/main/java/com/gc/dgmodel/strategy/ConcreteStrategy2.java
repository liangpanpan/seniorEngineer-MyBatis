package com.gc.dgmodel.strategy;

/**
 * 实现抽象策略中的操作，该类含有具体的算法。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class ConcreteStrategy2 implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }

}
