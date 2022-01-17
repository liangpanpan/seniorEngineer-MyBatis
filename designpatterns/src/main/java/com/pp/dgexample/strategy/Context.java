package com.pp.dgexample.strategy;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class Context {

    //构造函数，你要使用哪个妙计
    private IStrategy straegy;

    public Context(IStrategy strategy) {
        this.straegy = strategy;
    }

    //使用计谋了，看我出招了
    public void operate() {
        this.straegy.operate();
    }
}
