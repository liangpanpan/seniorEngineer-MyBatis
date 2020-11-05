package com.basic02log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/5       create this file
 * </pre>
 */
public class LogTest {

    static Logger LOGGER = LoggerFactory.getLogger(LogTest.class.getClass());

    public static void main(String[] args) {

        LOGGER.info("hello");


    }

}
