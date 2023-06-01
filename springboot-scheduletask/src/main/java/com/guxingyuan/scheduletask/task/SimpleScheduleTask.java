package com.guxingyuan.scheduletask.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/4/27       create this file
 * </pre>
 */
//@Component
public class SimpleScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(SimpleScheduleTask.class);

    @Scheduled(cron = "0 0 1 * * ?")
    public void checkTask() {
        logger.info("checkTask");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void printLog() {
        logger.info("printLog");
    }
}
