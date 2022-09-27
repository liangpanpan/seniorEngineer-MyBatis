package com.guxingyuan.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认读取的配置文件是：logback.xml或者logback-test.xml
 * <p>
 * logback在启动时：
 * <p>
 * 在 classpath 中寻找 logback-test.xml文件
 * 如果找不到 logback-test.xml，则在 classpath 中寻找 logback.groovy 文件
 * 如果找不到 logback.groovy，则在 classpath 中寻找 logback.xml文件
 * 如果上述的文件都找不到，则 logback 会使用 JDK 的 SPI 机制查找 META-INF/services/ch.qos.logback.classic.spi.Configurator 中的 logback
 * 配置实现类，这个实现类必须实现 Configuration 接口，使用它的实现来进行配置
 * 如果上述操作都不成功，logback 就会使用它自带的 BasicConfigurator 来配置，并将日志输出到 console
 *
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
