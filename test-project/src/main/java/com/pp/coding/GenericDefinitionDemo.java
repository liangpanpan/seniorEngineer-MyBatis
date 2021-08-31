package com.pp.coding;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/14       create this file
 * </pre>
 */
public class GenericDefinitionDemo<T> {

    static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
        return string;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first, second);
        System.out.println(result);
    }


}
