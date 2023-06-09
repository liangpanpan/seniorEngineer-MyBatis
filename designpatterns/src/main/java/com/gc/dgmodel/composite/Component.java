package com.gc.dgmodel.composite;

/**
 * 抽象构建角色
 * 定义参加组合对象的共有方法和属性，可以定义一些默认的行为或属性
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public abstract class Component {
    //个体和整体都具有的共享
    public void doSomething() {
        //编写业务逻辑
    }
}
