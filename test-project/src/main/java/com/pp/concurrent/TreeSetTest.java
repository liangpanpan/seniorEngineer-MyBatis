package com.pp.concurrent;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/10/9       create this file
 * </pre>
 */
public class TreeSetTest {

    public static void main(String[] args) {

        String udp = "UDP";
        String tcp = "TCP";

        Set<String> tempSet = new TreeSet<>();
        tempSet.add(udp);
        tempSet.add(tcp);

        StringJoiner joiner = new StringJoiner(",");
        tempSet.stream().forEach(temp -> {
            joiner.add(temp);
        });

        System.out.println(joiner.toString());

    }

}
