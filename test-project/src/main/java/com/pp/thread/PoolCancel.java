package com.pp.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/4       create this file
 * </pre>
 */
public class PoolCancel {
    public static void main(String[] args) {

        // 设置一个同步计算数，目的是让子线程完成工作后，主线程再继续工作。
        // 因为这里只有一个子线程，所以设值为 1
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 创建线程池
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);

        // 创建固定时延的定时任务
        ScheduledFuture<?> scheduledFuture = pool.scheduleWithFixedDelay(
                new Task2(countDownLatch, 10)
                , 0
                , 2, TimeUnit.SECONDS);

        try {
            // 暂停主线程，等待同步计算数器归零后，主线程再继续工作
            countDownLatch.await();
            // 同步计数器已归零，说明定时任务已满足条件退出
            // 所以取消定时任务
            scheduledFuture.cancel(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        pool.shutdown();
    }
}

class Task2 implements Runnable {

    CountDownLatch countDownLatch;
    private int counter;

    public Task2(CountDownLatch countDownLatch, int counter) {
        this.countDownLatch = countDownLatch;
        this.counter = counter;
    }

    @Override
    public void run() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 处理一些任务
        System.out.println(localDateTime.format(dtf) + " [" + Thread.currentThread().getName() + "] " + counter);

        if (counter-- == 0) {
            // 判断达到停止任务的条件
            countDownLatch.countDown();
        }
    }
}
