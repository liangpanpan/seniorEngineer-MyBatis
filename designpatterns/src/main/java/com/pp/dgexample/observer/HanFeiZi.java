package com.pp.dgexample.observer;

import java.util.Observable;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class HanFeiZi extends Observable implements IHanFeiZi {

    //韩非子要吃饭了
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        //通知所有的观察者
        this.notifyObservers("韩非子在吃饭");
    }

    //韩非子开始娱乐了
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        this.notifyObservers("韩非子在娱乐");
    }
}
