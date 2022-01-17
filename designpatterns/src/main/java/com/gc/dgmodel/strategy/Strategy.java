package com.gc.dgmodel.strategy;

/**
 * Strategy抽象策略角色
 * 策略、算法家族的抽象，通常为接口，定义每个策略或算法必须具有的方法和属性。各位看官可能要问了，类图中的AlgorithmInterface是什么意思，
 * 嘿嘿，algorithm是“运算法则”的意思，结合起来意思就明白了吧。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public interface Strategy {
    //策略模式的运算法则
    void doSomething();
}
