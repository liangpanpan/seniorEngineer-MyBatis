package com.gc.dgmodel.mediator;

/**
 * 通用抽象中介者
 * 中介者模式的定义为：用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public abstract class Mediator {

    protected ConcreteColleague1 concreteColleague1;

    protected ConcreteColleague2 concreteColleague2;


    /**
     * 具体业务逻辑一
     */
    public abstract void doSomething1();

    /**
     * 具体业务逻辑二
     */
    public abstract void doSomething2();

    public ConcreteColleague1 getConcreteColleague1() {
        return concreteColleague1;
    }

    public void setConcreteColleague1(ConcreteColleague1 concreteColleague1) {
        this.concreteColleague1 = concreteColleague1;
    }

    public ConcreteColleague2 getConcreteColleague2() {
        return concreteColleague2;
    }

    public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }
}
