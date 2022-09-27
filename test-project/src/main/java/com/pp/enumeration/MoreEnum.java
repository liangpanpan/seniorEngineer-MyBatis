package com.pp.enumeration;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/8/10       create this file
 * </pre>
 */
public class MoreEnum {

    enum EnumOne {
        SYSTEM_CREATE(0),
        USER_CREATE(1),
        DGA_CHECK(2),
        CONCEAL_TUNNEL(3);

        private Integer code;

        EnumOne(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    public enum EnumSecond {
        SYSTEM_CREATE(0),
        USER_CREATE(1),
        DGA_CHECK(2),
        CONCEAL_TUNNEL(3);

        private Integer code;

        EnumSecond(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }


}
