package com.gc.dgmodel.staticproxy;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }

}
