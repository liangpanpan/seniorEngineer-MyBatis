package com.guxingyuan.quartz.springboot;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * quartz util
 */
public class QuartzManager {
    private static final SchedulerFactory sf = new StdSchedulerFactory();
    private static final String JOB_GROUP_NAME = "group1";
    private static final String TRIGGER_GROUP_NAME = "trigger1";


    /** */
    /**
     * 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
     *
     * @param jobName 任务名
     * @param job     任务
     * @param time    时间设置，参考quartz说明文档
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobName, Job job, String time)
            throws SchedulerException, ParseException {
        addJob(jobName, job, time, null);
    }

    public static void addJob(String jobName, Job job, String time, Date start)
            throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobName, JOB_GROUP_NAME).build();
        //任务名，任务组，任务执行类

        // 触发器
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        // 触发器名,触发器组
        triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
        if (null != start) {
            triggerBuilder.startAt(start);
        } else {
            triggerBuilder.startNow();
        }

        // 触发器时间设定
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(time));
        // 创建Trigger对象
        CronTrigger trigger = (CronTrigger) triggerBuilder.build();

        sched.scheduleJob(jobDetail, trigger);
        //启动
        if (!sched.isShutdown())
            sched.start();
    }

    /**
     * @param jobName
     * @param job
     * @param time
     * @param start
     * @param jobDataMap
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobName, Job job, String time, Date start, JobDataMap jobDataMap)
            throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobName, JOB_GROUP_NAME).build();
        //任务名，任务组，任务执行类
        jobDetail.getJobDataMap().putAll(jobDataMap);
        // 触发器
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        // 触发器名,触发器组
        triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
        if (null != start) {
            triggerBuilder.startAt(start);
        } else {
            triggerBuilder.startNow();
        }

        // 触发器时间设定
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(time));
        // 创建Trigger对象
        CronTrigger trigger = (CronTrigger) triggerBuilder.build();

        sched.scheduleJob(jobDetail, trigger);
        //启动
        if (!sched.isShutdown())
            sched.start();
    }
    /** */
    /**
     * 添加一个定时任务
     *
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param job              任务
     * @param time             时间设置，参考quartz说明文档
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName,
                              Job job, String time)
            throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobName, jobGroupName).build();
        //任务名，任务组，任务执行类

        // 触发器
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        // 触发器名,触发器组
        triggerBuilder.withIdentity(triggerName, triggerGroupName);
        triggerBuilder.startNow();

        // 触发器时间设定
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(time));
        // 创建Trigger对象
        CronTrigger trigger = (CronTrigger) triggerBuilder.build();
        sched.scheduleJob(jobDetail, trigger);
        if (!sched.isShutdown())
            sched.start();
    }

    /** */
    /**
     * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
     *
     * @param jobName
     * @param time
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void modifyJobTime(String jobName, String time)
            throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        Trigger trigger = sched.getTrigger(triggerKey);
        if (trigger != null) {
            CronTrigger ct = (CronTrigger) trigger;

            String oldTime = ct.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                Date oldDate = ct.getStartTime();

                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
                if (null != oldDate) {
                    triggerBuilder.startAt(oldDate);
                } else {
                    triggerBuilder.startNow();
                }
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(time));
                // 创建Trigger对象
                ct = (CronTrigger) triggerBuilder.build();
                sched.rescheduleJob(triggerKey, ct);
            }
        }
    }

    public static void modifyJobTime(String jobName, String time, Date start)
            throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        Trigger trigger = sched.getTrigger(triggerKey);
        if (trigger != null) {
            CronTrigger ct = (CronTrigger) trigger;

            String oldTime = ct.getCronExpression();
            Date oldDate = ct.getStartTime();
            if (!oldTime.equalsIgnoreCase(time) || getDateLong(oldDate) != getDateLong(start)) {
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
                if (null != start) {
                    triggerBuilder.startAt(start);
                } else {
                    triggerBuilder.startNow();
                }
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(time));
                // 创建Trigger对象
                ct = (CronTrigger) triggerBuilder.build();
                sched.rescheduleJob(triggerKey, ct);
            }
        }
    }

    private static long getDateLong(Date date) {
        if (null == date) {
            return -1L;
        } else {
            return date.getTime();
        }
    }

    /** */
    /**
     * 修改一个任务的触发时间
     *
     * @param triggerName
     * @param triggerGroupName
     * @param time
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void modifyJobTime(String triggerName, String triggerGroupName,
                                     String time)
            throws SchedulerException, ParseException {
        Scheduler sched = sf.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
        Trigger trigger = sched.getTrigger(triggerKey);
        if (trigger != null) {
            CronTrigger ct = (CronTrigger) trigger;

            String oldTime = ct.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                Date oldDate = ct.getStartTime();
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                if (null != oldDate) {
                    triggerBuilder.startAt(oldDate);
                } else {
                    triggerBuilder.startNow();
                }
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(time));
                // 创建Trigger对象
                ct = (CronTrigger) triggerBuilder.build();
                sched.rescheduleJob(triggerKey, ct);
            }
        }
    }

    /** */
    /**
     * 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
     *
     * @param jobName
     * @throws SchedulerException
     */
    public static void removeJob(String jobName)
            throws SchedulerException {
        Scheduler sched = sf.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, TRIGGER_GROUP_NAME);
        sched.pauseTrigger(triggerKey);// 停止触发器
        sched.unscheduleJob(triggerKey);// 移除触发器
        sched.deleteJob(JobKey.jobKey(jobName, JOB_GROUP_NAME));// 删除任务


    }

    /** */
    /**
     * 移除一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @throws SchedulerException
     */
    public static void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName)
            throws SchedulerException {
        Scheduler sched = sf.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
        sched.pauseTrigger(triggerKey);// 停止触发器
        sched.unscheduleJob(triggerKey);// 移除触发器
        sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
    }

    /**
     * 关闭定时任务Scheduler
     *
     * @throws SchedulerException
     */
    public static void shutdown() throws SchedulerException {
        sf.getScheduler().shutdown();
    }


}  