package com.gc.dgmodel.abstractfactory;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public abstract class AbstractCreator {
    //创建A产品家族
    public abstract AbstractProductA createProductA();

    //创建B产品家族
    public abstract AbstractProductB createProductB();
}
