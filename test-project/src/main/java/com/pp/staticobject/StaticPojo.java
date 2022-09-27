package com.pp.staticobject;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/7/1       create this file
 * </pre>
 */
public class StaticPojo {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StaticPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
