package com.gc.dgmodel.factory;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class Client {
    public static void main(String[] args) {

        Creator creator = new ConcreteCreator();
        ConcreteProduct1 concreteProduct1 =
                creator.createProduct(ConcreteProduct1.class);
        concreteProduct1.method2();

        ConcreteProduct2 concreteProduct2 =
                creator.createProduct(ConcreteProduct2.class);
        concreteProduct2.method2();
    }
}
