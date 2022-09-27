package com.guxingyuan.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/9/27       create this file
 * </pre>
 */
public class WriteLogThread extends Thread {

    Logger logger;

    public WriteLogThread(int threadName) {
        logger = LoggerFactory.getLogger(WriteLogThread.class.getName() + "-" + threadName);
    }

    @Override
    public void run() {
        long index = 0L;
        while (true) {
            logger.info("log info ********" + index++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
