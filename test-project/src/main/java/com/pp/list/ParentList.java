package com.pp.list;


import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/11/18       create this file
 * </pre>
 */
public abstract class ParentList {

    private List<Person> testList;

    public List<Person> getTestList() {
        return testList;
    }

    public void setTestList(List<Person> testList) {
        this.testList = testList;
    }
}
