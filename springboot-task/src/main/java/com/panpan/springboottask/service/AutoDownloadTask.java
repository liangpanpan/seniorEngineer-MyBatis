package com.panpan.springboottask.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/5       create this file
 * </pre>
 */
@Slf4j
@Component
public class AutoDownloadTask {

    private Object object = new Object();

    private ScheduledThreadPoolExecutor executorService;

    private ScheduledFuture<?> nextScheduledFuture;

    private ScheduledFuture<?> currentScheduledFuture;

    private boolean runner = true;

    private int count = 0;

    @Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        String getCron();
    }

    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;


    public AutoDownloadTask() {
        executorService = new ScheduledThreadPoolExecutor(5);
    }

    /**
     * 添加下载任务
     *
     * @param flag
     */
    public void addDownLoadTask(int flag) {
        synchronized (object) {
            if (0 == flag) {
                // 系统进行初次请求的时候
                log.info("execute 第" + count + "任务");
                cancel();
                new Thread(new BeatTask()).start();
            } else {
                // 系统重启的时候
                String taskTimeStr = cronMapper.getCron();
                if (StringUtils.isEmpty(taskTimeStr)) {
                    return;
                }
                // 计算需要延迟的时间
                long taskDelayTime = countDelayTime(taskTimeStr);
                cancel();
                executorService.schedule(new BeatTask(), taskDelayTime, TimeUnit.SECONDS);
            }

            // executeDownLoadHandler();
            // System.out.println();

            // 发送心跳的具体逻辑在 BeatTask 中
            // 这里会生成一个延时任务
            // nextScheduledFuture = executorService.schedule(new BeatTask(seconds), seconds, TimeUnit.SECONDS);
        }
    }

    private long countDelayTime(String taskTimeStr) {
        // 计算时间格式
        TaskTime taskTime = new TaskTime(taskTimeStr);

        // 计算下次的时间

        Calendar nowCalendar = Calendar.getInstance();

        Calendar cronCalendar = Calendar.getInstance();
        cronCalendar.set(Calendar.HOUR_OF_DAY, taskTime.getHour());
        cronCalendar.set(Calendar.MINUTE, taskTime.getMinute());
        cronCalendar.set(Calendar.SECOND, taskTime.getSecond());

        long delayTime = 0L;

        if (cronCalendar.before(nowCalendar)) {
            cronCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        delayTime = (cronCalendar.getTimeInMillis() - nowCalendar.getTimeInMillis()) / 1000;
        return delayTime;
    }


    private void executeDownLoadHandler() throws InterruptedException {
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

        public BeatTask() {
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
            long delayTime = 60;
            nextScheduledFuture = executorService.schedule(new BeatTask(), delayTime, TimeUnit.SECONDS);
            executeDownLoadHandler();
            log.info("finish beat task\r\n");
        }
    }


    class TaskTime {
        int hour = 0;
        int minute = 0;
        int second = 0;

        public TaskTime(String time) {
            // 先进行split
            String[] times = time.split(":");

            if (times.length > 0) {
                this.hour = Integer.valueOf(times[0]).intValue();
            }

            if (times.length > 1) {
                this.minute = Integer.valueOf(times[1]).intValue();
            }
            if (times.length > 2) {
                this.second = Integer.valueOf(times[2]).intValue();
            }
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }
    }


}
