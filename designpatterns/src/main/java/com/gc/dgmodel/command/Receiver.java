package com.gc.dgmodel.command;

/**
 * 通用Receiver类 接收者角色
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public abstract class Receiver {

    //抽象接收者，定义每个接收者都必须完成的业务
    public abstract void doSomething();

}
