package com.pp.jvm;

/**
 * @vlog: 条条大路通罗码
 * @desc: 描述
 * @author: ppliang
 * @createDate: 2020/6/11 22:08
 * @version: v1.0
 */
public class TestDynamicLoad {
    static {
        System.out.println("***********load " +
                "TestDynamicLoad*******************");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("*********load test*****************");
        B b = null;
    }
}

class A {
    static {
        System.out.println("**********load A***********");
    }

    public A() {
        System.out.println("**********initial A*************");
    }
}

class B {
    static {
        System.out.println("**********load B***********");
    }

    public B() {
        System.out.println("**********initial B*************");
    }
}