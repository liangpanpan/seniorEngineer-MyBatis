package com.basic02aop;

import com.basic02aop.entify.User;
import com.basic02aop.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/15       create this file
 * </pre>
 */
public class SpringAOPTest {

    ApplicationContext aop;

    @Before
    public void before() {
        aop = new ClassPathXmlApplicationContext("classpath:com\\basic02aop\\spring_aop.xml");
    }


    /**
     * 打印的结果信息为：
     * @Before：切点方法之前执行.....
     * 访问获取User信息
     * @After：切点方法之后执行.....
     * @AfterReturning：切点方法返回后执行.....
     * 返回值：User{id=2, name='梁盼盼', age=34}
     * User{id=2, name='梁盼盼', age=34}
     */
    @Test
    public void testAop01() {
        IUserService bean = aop.getBean(IUserService.class);
        User user = bean.getUser(02);
        System.out.println(user);
    }

}
