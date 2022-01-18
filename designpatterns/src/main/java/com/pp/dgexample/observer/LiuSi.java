package com.pp.dgexample.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class LiuSi implements Observer {

    //刘斯，观察到韩非子活动后，自己也得做一些事
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("刘斯：观察到韩非子活动，开始动作了...");
        this.happy(arg.toString());
        System.out.println("刘斯：乐死了\n");
    }

    //一看韩非子有变化，他就快乐
    private void happy(String context) {
        System.out.println("刘斯：因为" + context + ",--所以我快乐呀！");
    }
}
