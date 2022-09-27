package com.pp.enumeration;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/8/10       create this file
 * </pre>
 */
public class TestEnum {

    public static void main(String[] args) {
        System.out.println(EventSourceEnum.SYSTEM_CREATE);
        System.out.println(EventSourceEnum.SYSTEM_CREATE.getCode());


        System.out.println(MoreEnum.EnumOne.SYSTEM_CREATE);
        System.out.println(MoreEnum.EnumOne.SYSTEM_CREATE.name());

    }

}
