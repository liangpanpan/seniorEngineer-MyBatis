package com.gc.dgmodel.mediator;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void doSomething1() {
        super.concreteColleague1.selfMethod1();
        super.concreteColleague2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.concreteColleague1.selfMethod1();
        super.concreteColleague2.selfMethod2();
    }
}
