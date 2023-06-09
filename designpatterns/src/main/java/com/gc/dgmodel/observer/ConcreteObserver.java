package com.gc.dgmodel.observer;

/**
 * 具体的观察者
 * 每个观察在接收到消息后的处理反应是不同的，每个观察者有自己的处理逻辑
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class ConcreteObserver implements Observer {
    //实现更新方法
    public void update() {
        System.out.println("接收到信息，并进行处理！");
    }
}
