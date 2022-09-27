package com.pp.enumeration;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/18       create this file
 * </pre>
 */
public enum EventSourceEnum {

    SYSTEM_CREATE(0),
    USER_CREATE(1),
    DGA_CHECK(2),
    CONCEAL_TUNNEL(3);

    private Integer code;

    EventSourceEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static EventSourceEnum getEventSourceEnum(Integer source) {
        for (EventSourceEnum value : values()) {
            if (source.equals(value.getCode())) {
                return value;
            }
        }
        return null;
    }

}
