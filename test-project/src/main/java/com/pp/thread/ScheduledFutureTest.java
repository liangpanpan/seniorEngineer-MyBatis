package com.pp.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/5/25       create this file
 * </pre>
 */
public class ScheduledFutureTest {


    private static final Logger logger = LoggerFactory.getLogger(ScheduledFutureTest.class);

    public static void main(String[] args) throws InterruptedException {

        logger.info("start");

        ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(5);

        ScheduledFuture<?> schedule = executorService.schedule(new TestTask(), 5, TimeUnit.SECONDS);
        ScheduledFuture<?> schedule2 = executorService.schedule(new TestTask(), 15, TimeUnit.SECONDS);

        logger.info("sleep start");
        Thread.sleep(1000 * 10);

        logger.info("cancel start");
        schedule.cancel(true);
        schedule2.cancel(true);


        Thread.sleep(1000 * 20);

        logger.info("finish, schedule1 isDone:{} cancel:{}, schedule2 isDone:{} cancel:{}", schedule.isDone(),
                schedule.isCancelled(), schedule2.isDone(), schedule2.isCancelled());

        List<Runnable> runnables = executorService.shutdownNow();
        logger.info("shutdown runnable size:{}", runnables.size());
        runnables.forEach(runnable -> logger.info(runnable.toString()));

        logger.info("sss");
    }


}
