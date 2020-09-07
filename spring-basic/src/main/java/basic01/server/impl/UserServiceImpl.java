package basic01.server.impl;

import basic01.dao.IUserDao;
import basic01.server.IUserService;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/7       create this file
 * </pre>
 */
public class UserServiceImpl implements IUserService {

    IUserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }


    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
