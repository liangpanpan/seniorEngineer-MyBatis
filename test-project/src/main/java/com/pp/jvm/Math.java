package com.pp.jvm;

/**
 * @vlog: 条条大路通罗码
 * @desc: 描述
 * @author: ppliang
 * @createDate: 2020/6/11 22:05
 * @version: v1.0
 */
public class Math {

    public static final int initDate = 666;

    public static User user = new User();

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Math math = new Math();
        math.compute();

        Class c = Class.forName("com.pp.jvm.Math");
        System.out.println(c.getName());

        String name = c.getName();

        Object object = new Object();

    }

}
