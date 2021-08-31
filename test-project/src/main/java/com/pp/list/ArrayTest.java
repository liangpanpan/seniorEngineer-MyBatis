package com.pp.list;

import java.util.ArrayList;

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
public class ArrayTest {

    public static void main(String[] args) {
        Object[] objects = new Object[5];
        for (int i = 0; i < 5; i++) {
            objects[i] = i;
        }
        ArrayTest test = new ArrayTest();
        // test.sout(objects);

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integers.add(i);
        }

        System.out.println("1:" + integers.toString());


        Object[] objs = new Object[6];
        integers.toArray(objs);
        for (int index = 0; index < objs.length; index++) {
            System.out.println("第" + index + ":" + objs[index]);
        }
    }


    public void sout(Object... arg) {
        System.out.println(arg);
    }

}
