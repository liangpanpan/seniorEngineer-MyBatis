package com.gc.dgmodel.bridge;

/**
 * 桥梁模式（Bridge Pattern）也叫做桥接模式，是一个比较简单的模式，
 * 其定义如下：Decouple an abstraction from its implementation so that the two can vary independently.
 * （将抽象和实现解耦，使得两者可以独立地变化。）
 * 桥梁模式的重点是在“解耦”上，如何让它们两者解耦是我们要了解的重点
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class Client {
    public static void main(String[] args) {
        //定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();
        //定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(imp);
        //执行行文
        abs.request();
    }
}
