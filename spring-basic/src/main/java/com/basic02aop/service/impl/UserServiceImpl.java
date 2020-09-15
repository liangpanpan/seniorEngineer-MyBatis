package com.basic02aop.service.impl;

import com.basic02aop.dao.IUserDao;
import com.basic02aop.entify.User;
import com.basic02aop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/15       create this file
 * </pre>
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
}
