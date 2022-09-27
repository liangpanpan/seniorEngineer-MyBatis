package com.pp.staticobject;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/7/1       create this file
 * </pre>
 */
public class ParentUtil {

    private static StaticPojo staticPojo;

    public static void setStaticPojo(StaticPojo staticPojo) {
        ParentUtil.staticPojo = staticPojo;
    }

    public static StaticPojo getStaticPojo() {
        return staticPojo;
    }

    public static void print() {
        System.out.println(getStaticPojo());
    }
}
