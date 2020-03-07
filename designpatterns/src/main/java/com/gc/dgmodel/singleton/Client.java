package com.gc.dgmodel.singleton;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class Client {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getSingleton();

        singleton.doSomething();
    }
}
