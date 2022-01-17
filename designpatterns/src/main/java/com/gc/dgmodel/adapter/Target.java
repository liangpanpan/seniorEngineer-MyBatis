package com.gc.dgmodel.adapter;

/**
 * 该角色定义把其他类转换为何种接口，也就是我们的期望接口，例子中的IUserInfo接口就是目标角色。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public interface Target {
    //目标角色有自己的方法
    void request();
}
