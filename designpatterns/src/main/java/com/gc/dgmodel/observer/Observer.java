package com.gc.dgmodel.observer;

/**
 * 观察者
 * 观察者接收到消息后，即进行update（更新方法）操作，对接收到的信息进行处理。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public interface Observer {
    //更新方法
    void update();
}
