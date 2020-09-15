package com.basic02aop.dao;

import com.basic02aop.entify.User;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/15       create this file
 * </pre>
 */
public interface IUserDao {

    User getUser(Integer id);

}
