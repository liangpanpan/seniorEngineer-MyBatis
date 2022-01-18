package com.pp.dgexample.iterator;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public interface IProject {
    //增加项目
    void add(String name, int num, int cost);

    //从老板这里看到的就是项目信息
    String getProjectInfo();

    //获得一个可以被遍历的对象
    IProjectIterator iterator();

}
