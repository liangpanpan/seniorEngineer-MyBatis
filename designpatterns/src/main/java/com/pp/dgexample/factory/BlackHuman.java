package com.pp.dgexample.factory;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class BlackHuman implements Human {

    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的！");
    }

    public void talk() {
        System.out.println("黑人会说话，一般人听不懂。");
    }
}
