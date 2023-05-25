package com.pp.concurrent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/5/13       create this file
 * </pre>
 */
public class ListFilter {


    @Test
    public void test01() {
        Stream<Integer> stream = Stream.of(2, 3, 4, 5, 6, 7);
        Stream<Integer> stream2 = Stream.iterate(1, x -> x + 2).limit(10);
        stream2.forEach(System.out::println);
    }

    @Test
    public void test02() {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringList.add("" + i);
        }

        List collect =
                stringList.stream().filter(s -> !("0".equals(s) || "3".equals(s)))
                        .map(i -> {
                            HashMap<String, String> map =
                                    new HashMap<>();
                            map.put(i, i);
                            return map;
                        }).collect(Collectors.toList());

        collect.stream().forEach(System.out::println);
    }
}
