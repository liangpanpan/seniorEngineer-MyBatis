package basic01.dao.impl;

import basic01.dao.IUserDao;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/7       create this file
 * </pre>
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public void getUser() {
        System.out.println("查询User信息");
    }
}
