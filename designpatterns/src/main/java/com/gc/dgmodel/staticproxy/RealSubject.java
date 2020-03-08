package com.gc.dgmodel.staticproxy;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class RealSubject implements Subject {
    //实现方法
    public void request() {
        //业务逻辑处理
        System.out.println("RealSubject request");
    }
}
