package com.panpan.springboottask.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/4       create this file
 * </pre>
 */
@Slf4j
public class BeatReactor {

    private Object object = new Object();

    private ScheduledThreadPoolExecutor executorService;

    private ScheduledFuture<?> nextScheduledFuture;

    private ScheduledFuture<?> currentScheduledFuture;

    private boolean runner = true;
    /**
     * 表示正在执行
     */
    private boolean execute = false;

    private int count = 0;

    private ReentrantLock mainLock = new ReentrantLock();

    public BeatReactor() {
        // 创建一个线程池
        executorService = new ScheduledThreadPoolExecutor(5);
    }

    public ScheduledFuture<?> getNextScheduledFuture() {
        return nextScheduledFuture;
    }

    public ScheduledFuture<?> getCurrentScheduledFuture() {
        return currentScheduledFuture;
    }

    public void setRunner(boolean runner) {
        this.runner = runner;
    }

    public boolean isRunner() {
        return runner;
    }

    public void addBeatInfo(long seconds) throws InterruptedException {
        // synchronized (object) {

        // 使用ReentrantLock
        mainLock.lock();
        try {
            log.info("execute 第" + count + "任务");
            cancel();

            executeBeatHandler();
            System.out.println();

            // 发送心跳的具体逻辑在 BeatTask 中
            // 这里会生成一个延时任务
            nextScheduledFuture = executorService.schedule(new BeatTask(seconds), seconds, TimeUnit.SECONDS);
        } finally {
            mainLock.unlock();
        }
    }

    private void executeBeatHandler() throws InterruptedException {
        try {
            log.info("start executeBeatHandler：" + count);
            // 这里是发送心跳检测
            Thread.sleep(10000);
            log.info("finish executeBeatHandler: " + count);
            count++;
        } catch (InterruptedException ex) {
            log.error("error", ex);
            throw ex;
        }
    }

    public void cancel() {
        // 先将任务置为false
        runner = false;

        try {
            // 先关闭下一次再关闭当前
            if (nextScheduledFuture != null) {
                nextScheduledFuture.cancel(true);
                log.info("cancel next ScheduledFuture");
            } else {
                log.info("NextScheduledFuture is null");
            }
            if (currentScheduledFuture != null) {
                currentScheduledFuture.cancel(true);
                log.info("cancel current ScheduledFuture");
            } else {
                log.info("CurrentScheduledFuture is null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            runner = true;
        }
    }


    class BeatTask implements Runnable {

        private long seconds;

        public BeatTask(long seconds) {
            this.seconds = seconds;
        }

        @SneakyThrows
        @Override
        public void run() {
            if (!runner) {
                return;
            }
            // 先准备开启下一个任务
            // 发送一个心跳后，延迟nextTime，继续发送下一个心跳
            currentScheduledFuture = nextScheduledFuture;
            nextScheduledFuture = executorService.schedule(new BeatTask(seconds), seconds, TimeUnit.SECONDS);
            executeBeatHandler();
            log.info("finish beat task\r\n");
        }
    }

}
