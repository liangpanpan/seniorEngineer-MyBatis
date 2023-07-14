package com.guxingyuan.quartz.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/7/14       create this file
 * </pre>
 */
public class SpringQuartz {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("SimpleTrigger.xml");

        System.out.println("111");

    }

}
