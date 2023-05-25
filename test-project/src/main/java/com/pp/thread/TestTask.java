package com.pp.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/5/25       create this file
 * </pre>
 */
public class TestTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            logger.info("threadName:" + Thread.currentThread().getName() + "print:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("thread:{} finish", Thread.currentThread().getName());
    }
}
