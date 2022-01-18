package com.gc.dgmodel.visitor;

/**
 * 抽象访问者，一般是有几个具体元素就有几个访问方法
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public interface IVisitor {
    //可以访问哪些对象
    void visit(ConcreteElement1 el1);

    void visit(ConcreteElement2 el2);
}
