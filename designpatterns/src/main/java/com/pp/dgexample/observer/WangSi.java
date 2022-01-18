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
public class WangSi implements Observer {

    //王斯，看到韩非子有活动
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("王斯：观察到韩非子活动，自己也开始活动了...");
        this.cry(arg.toString());
        System.out.println("王斯：哭死了...\n");
    }

    //一看韩非子有活动，他就痛哭
    private void cry(String context) {
        System.out.println("王斯：因为" + context + "，--所以我悲伤呀！");
    }
}
