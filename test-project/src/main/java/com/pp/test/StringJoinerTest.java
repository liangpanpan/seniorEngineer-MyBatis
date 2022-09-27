package com.pp.test;

import java.util.StringJoiner;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/5/16       create this file
 * </pre>
 */
public class StringJoinerTest {

    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");

        stringJoiner.add("123");
        stringJoiner.add("");


        System.out.println(stringJoiner);


    }

}
