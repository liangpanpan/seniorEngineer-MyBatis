package com.panpan.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/7       create this file
 * </pre>
 */
@EnableScheduling
@SpringBootApplication
public class LogbackApplication {


    private static final Logger logger = LoggerFactory.getLogger(LogbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);

        RuntimeException exception = new RuntimeException("异常测试");

        logger.error("保存error", exception);

        logger.info("info test");


        logger.error("error test");
    }

}
