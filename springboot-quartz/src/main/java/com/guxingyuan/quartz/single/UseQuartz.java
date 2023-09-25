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
        //给调度器添加任务和触发器
        scheduler.scheduleJob(job, trigger);
    }

    private static SimpleScheduleBuilder simpleSchedule() {
        //指定日程制定器重复执行
        return SimpleScheduleBuilder.repeatHourlyForever();
    }


    /**
     * 要实现任务的接口
     *
     * @DisallowConcurrentExecution
     * 禁止并发执行多个相同定义的JobDetail, 这个注解是加在Job类上的, 但意思并不是不能同时执行多个Job, 而是不能并发执行同一个Job Definition(由JobDetail定义),
     * 但是可以同时执行多个不同的JobDetail。
     * 即对于同一个Job任务不允许并发执行，但对于不同的job任务不受影响。
     *
     * @PersistJobDataAfterExecution
     * 保存在JobDataMap传递的参数。加在Job上,表示当正常执行完Job后, JobDataMap中的数据应该被改动, 以被下一次调用时用。
     * job接口内可以获取JobDataMap,对JobDataMap进行修改，传递给下一次执行的任务
     * JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
     *
     */
    @DisallowConcurrentExecution
    public static class MyJob implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            logger.info("小狗子啃骨头咯!");

            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logger.info("当前线程结束");
        }
    }
}
