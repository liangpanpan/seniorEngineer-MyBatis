package com.pp.test;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/6/21       create this file
 * </pre>
 */
public class StringTest {

    /**
     * 案例
     */
    public static void test1() {
        String test1 = "abc";
        String test2 = "abc";
        System.out.println(test1 == test2);
    }

    public static void test2() {
        String test1 = "a" + "b" + "c";
        String test2 = "abc";
        System.out.println(test1 == test2);
    }

    public static void test3() {
        String test1 = "abc";
        String test2 = new String("abc");
        System.out.println(test1 == test2);
    }

    public static void test4() {
        String test1 = new String("abc");
        String test2 = new String("abc");
        System.out.println(test1 == test2);
    }

    public static void test5() {
        String test1 = "ab" + new String("c");
        String test2 = new String("abc");
        System.out.println(test1 == test2);
    }

    public static void test6() {
        String test1 = "ab" + new String("c");
        String test2 = "abc";
        String test3 = test1.intern();
        System.out.println(test1 == test2);
        System.out.println(test1 == test3);
        System.out.println(test2 == test3);
    }


    public static void main(String[] args) {
        System.out.println("========test 1=============");
        test1();

        System.out.println("========test 2=============");
        test2();

        System.out.println("========test 3=============");
        test3();

        System.out.println("========test 4=============");
        test4();

        System.out.println("========test 5=============");
        test5();

        System.out.println("========test 6=============");
        test6();
    }


}
