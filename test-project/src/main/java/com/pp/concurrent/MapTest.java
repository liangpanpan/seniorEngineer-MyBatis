package com.pp.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/6/22       create this file
 * </pre>
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String, String> test = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            test.put(i + "", "num:" + i);
        }
    }

}
