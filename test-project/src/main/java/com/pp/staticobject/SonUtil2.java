package com.pp.staticobject;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/7/1       create this file
 * </pre>
 */
public class SonUtil2 extends ParentUtil {

    private static StaticPojo staticPojo;

    public static void setStaticPojo(StaticPojo staticPojo) {
        SonUtil2.staticPojo = staticPojo;
    }

    public static StaticPojo getStaticPojo() {
        return SonUtil2.staticPojo;
    }
}
