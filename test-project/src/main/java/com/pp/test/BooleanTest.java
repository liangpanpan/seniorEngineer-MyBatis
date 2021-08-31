package com.pp.test;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/18       create this file
 * </pre>
 */
public class BooleanTest {

    public static void main(String[] args) {
        Boolean flag = null;

        /**
         * Boolean使用if判断的时候，不能是null，不行有值，否则会提示
         * java.lang.NullPointerException
         */
        if (flag) {
            System.out.println("true");
        } else if (!flag) {
            System.out.println("false");
        } else {
            System.out.println("null");
        }


    }

}
