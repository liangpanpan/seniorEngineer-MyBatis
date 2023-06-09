package com.gc.dgmodel.observer;

/**
 * 具体的被观察者
 * 定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class ConcreteSubject extends Subject {
    //具体的业务
    public void doSomething() {
        /*
         * do something
         */
        super.notifyObservers();
    }
}
