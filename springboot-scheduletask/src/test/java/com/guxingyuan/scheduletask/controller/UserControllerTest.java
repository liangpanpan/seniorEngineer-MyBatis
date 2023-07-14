package com.guxingyuan.scheduletask.controller;

import com.guxingyuan.scheduletask.Application;
import com.guxingyuan.scheduletask.domain.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/28       create this file
 * </pre>
 */
@SpringBootTest(classes = Application.class)
public class UserControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Resource
    private UserController userController;

    @Test
    public void testAddUser() throws InterruptedException {

        User user = new User();
        user.setUserId("111111");
        user.setUserName("lpp");
        user.setAge("36");
        user.setNumber(1);

        for (int i = 0; i < 20; i++) {
            String s = userController.addUser(user);
            logger.info("time:{}, res:{}", i, s);

            TimeUnit.SECONDS.sleep(1);
        }


    }


}
