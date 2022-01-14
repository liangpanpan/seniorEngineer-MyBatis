package com.pp.dgexample.chain;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public interface IWomen {
    public int getType();

    //获得个人请示，你要干什么？出去逛街？约会?还是看电影？
    public String getRequest();
}
