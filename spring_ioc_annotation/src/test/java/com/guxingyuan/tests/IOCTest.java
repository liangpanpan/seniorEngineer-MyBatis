package com.guxingyuan.tests;

import com.guxingyuan.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/9       create this file
 * </pre>
 */
public class IOCTest {

    @Test
    public void test01() {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring_ioc.xml");
        UserController bean = applicationContext.getBean(UserController.class);
        System.out.println(bean);
    }
}
