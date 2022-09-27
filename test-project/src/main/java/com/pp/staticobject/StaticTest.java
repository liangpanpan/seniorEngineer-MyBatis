package com.pp.staticobject;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/7/1       create this file
 * </pre>
 */
public class StaticTest {

    public static void main(String[] args) {

        StaticPojo staticPojo = new StaticPojo();
        staticPojo.setId("1");
        staticPojo.setName("name1");
        ParentUtil.setStaticPojo(staticPojo);

        staticPojo = new StaticPojo();
        staticPojo.setId("2");
        staticPojo.setName("name2");
        SonUtil1.setStaticPojo(staticPojo);

        staticPojo = new StaticPojo();
        staticPojo.setId("3");
        staticPojo.setName("name3");
        SonUtil2.setStaticPojo(staticPojo);

        ParentUtil.print();
        SonUtil1.print();
        SonUtil2.print();
    }

}
