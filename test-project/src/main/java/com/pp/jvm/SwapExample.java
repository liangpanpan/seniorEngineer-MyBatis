package com.pp.jvm;

import java.lang.reflect.Field;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/12/21       create this file
 * </pre>
 */
public class SwapExample {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("交换前：a=" + a + ",b=" + b);
        swap(a, b);
        System.out.println("交换后：a=" + a + ",b=" + b);
    }


    private static void swap(Integer a, Integer b) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            Integer temp = new Integer(a);
            field.setAccessible(true); //针对private修饰的变量，需要通过该方法设置。
            field.set(a, b);
            field.set(b, temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
