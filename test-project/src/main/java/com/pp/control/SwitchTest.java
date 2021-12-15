package com.pp.control;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/12/15       create this file
 * </pre>
 */
public class SwitchTest {

    public static void main(String[] args) {
        // 传递为null会提示NullPointerException
        method(null);
    }

    public static void method(String param) {
        switch (param) {
            case "sth":
                System.out.println("it is sth");
                break;
            case "null":
                System.out.println("it is null");
                break;
            default:
                System.out.println("default");
        }

    }

}
