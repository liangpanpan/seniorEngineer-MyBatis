package com.basic02aop.dao.impl;

import com.basic02aop.dao.IUserDao;
import com.basic02aop.entify.User;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/15       create this file
 * </pre>
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Override
    public User getUser(Integer id) {

        if (01 == id) {
            throw new RuntimeException("获取用户信息出错");
        }

        User user = new User();
        user.setId(id);
        user.setName("梁盼盼");
        user.setAge(34);
        System.out.println("访问获取User信息");
        return user;
    }
}
