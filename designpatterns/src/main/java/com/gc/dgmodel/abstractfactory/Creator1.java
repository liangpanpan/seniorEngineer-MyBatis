package com.gc.dgmodel.abstractfactory;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class Creator1 extends AbstractCreator {

    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
