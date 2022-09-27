package com.guxingyuan.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认读取的配置文件是：logback.xml或者logback-test.xml
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/9/27       create this file
 * </pre>
 */
public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {

        logger.info("hello");

        WriteLogThread writeLogThread1 = new WriteLogThread(1);
        WriteLogThread writeLogThread2 = new WriteLogThread(2);
        WriteLogThread writeLogThread3 = new WriteLogThread(3);

        writeLogThread1.start();
        writeLogThread2.start();
        writeLogThread3.start();


    }


}
