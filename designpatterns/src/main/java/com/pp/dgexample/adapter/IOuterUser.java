package com.pp.dgexample.adapter;

import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public interface IOuterUser {
    //基本信息，比如名称、性别、手机号码等
    Map getUserBaseInfo();

    //工作区域信息
    Map getUserOfficeInfo();

    //用户的家庭信息
    Map getUserHomeInfo();
}
