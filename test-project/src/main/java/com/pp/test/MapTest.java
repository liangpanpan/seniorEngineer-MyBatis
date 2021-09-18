package com.pp.test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/7/2       create this file
 * </pre>
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i + "", i + "");
        }

        System.out.println(map.get(Integer.valueOf(1).toString()));

    }
}
