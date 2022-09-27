package com.pp.test;

import java.util.Arrays;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/5/16       create this file
 * </pre>
 */
public class SplitTest {

    public static void main(String[] args) {

        String s = "12,34,56";

        System.out.println(s.split(",").length);
        Arrays.stream(s.split(",")).forEach(System.out::println);

    }

}
