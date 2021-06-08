package com.gc.dgmodel.factory;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public abstract class Product {
    //产品类的公共方法
    public void method1() {
        //业务逻辑处理
        System.out.println("method1");
    }

    //抽象方法
    public abstract void method2();
}
