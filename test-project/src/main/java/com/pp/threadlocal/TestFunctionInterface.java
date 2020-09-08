package com.pp.threadlocal;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/2       create this file
 * </pre>
 */
@FunctionalInterface
public interface TestFunctionInterface {

    public void test();

    default String getName() {
        return "111";
    }

    default String getAge() {
        return "2;";
    }
}
