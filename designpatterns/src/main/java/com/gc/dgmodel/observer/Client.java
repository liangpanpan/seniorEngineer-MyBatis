package com.gc.dgmodel.observer;

/**
 * 观察者模式（Observer Pattern)也叫做发布订阅模式（publish/subscribe）
 * 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class Client {

    public static void main(String[] args) {
        // 定义一个观察者
        Observer obs = new ConcreteObserver();

        // 创建一个被观察者
        ConcreteSubject subject = new ConcreteSubject();
        // 观察者观察被观察者
        subject.addObserver(obs);
        // 观察者开始活动了
        subject.doSomething();
    }
}
