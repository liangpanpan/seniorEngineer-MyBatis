package com.guxingyuan.quartz.single;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/7/14       create this file
 * </pre>
 */
public class UseQuartz {

    private static final Logger logger = LoggerFactory.getLogger(UseQuartz.class);

    //获得日志信息
    public static void main(String[] args) {

        //获得调度器,在StdScheduleFactory工厂取
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            //开启调度器
            scheduler.start();
            // 注册一个示例任务和触发器
            registerJobAndTrigger(scheduler);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void registerJobAndTrigger(Scheduler scheduler) throws SchedulerException {

        //创建一个示例任务,需要指定任务的位置
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("mySimpleJob", "simpleGroup")
                .build();
        //创建一个触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("simpleTrigger", "simpleGroup")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5))
                .build();
        scheduler.scheduleJob(job, trigger);
        //给调度器添加任务和触发器
    }

    private static SimpleScheduleBuilder simpleSchedule() {
        //指定日程制定器重复执行
        return SimpleScheduleBuilder.repeatHourlyForever();
    }


    //要实现任务的接口
    public static class MyJob implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            logger.info("小狗子啃骨头咯!");
        }
    }
}
