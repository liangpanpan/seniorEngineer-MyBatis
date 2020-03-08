package com.gc.dgmodel.dynamicproxy;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class RealSubject implements Subject {

    //业务操作
    public void doSomething(String str) {
        System.out.println("do something!---->" + str);
    }
}
