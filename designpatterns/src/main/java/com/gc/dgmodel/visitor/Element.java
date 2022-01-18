package com.gc.dgmodel.visitor;

/**
 * 接口或者抽象类，声明接受哪一类访问者访问，程序上是通过accept方法中的参数来定义的。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public abstract class Element {
    //定义业务逻辑
    public abstract void doSomething();

    //允许谁来访问
    public abstract void accept(IVisitor visitor);
}
