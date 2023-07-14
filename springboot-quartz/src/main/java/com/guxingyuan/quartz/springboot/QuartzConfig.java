package com.guxingyuan.quartz.springboot;

import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Objects;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/7/14       create this file
 * </pre>
 */
@Configuration  //标记配置类
public class QuartzConfig {


    //定时任务的Bean, 在Bean中参数会去Spring容器中找
    @Bean(name = "detailFactoryBean1")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean1(QuartzService quartzService) {
        //创建一个MethodInvokingJobDetailFactoryBean对象,来指定要调度的定时任务
        MethodInvokingJobDetailFactoryBean detailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        //指定定时任务的对象
        detailFactoryBean.setTargetObject(quartzService);
        //指定定时任务的方法
        detailFactoryBean.setTargetMethod("test1");
        //concurrent: 为false,多个任务不能并发执行，必须等待前一个定时任务完成才能执行
        //为true.则可以并发执行
        detailFactoryBean.setConcurrent(false);
        return detailFactoryBean;
    }

    @Bean(name = "detailFactoryBean2")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean2(QuartzService quartzService) {
        //创建一个MethodInvokingJobDetailFactoryBean对象,来指定要调度的定时任务
        MethodInvokingJobDetailFactoryBean detailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        //指定定时任务的对象
        detailFactoryBean.setTargetObject(quartzService);
        //指定定时任务的方法
        detailFactoryBean.setTargetMethod("test2");
        //concurrent: 为false,多个任务不能并发执行，必须等待前一个定时任务完成才能执行
        //为true.则可以并发执行
        detailFactoryBean.setConcurrent(false);
        return detailFactoryBean;
    }

    //触发器的Bean，为触发器设定触发任务条件 ，使用Cron表达式工厂的Bean
    @Bean(name = "cronTriggerBean1")               //有多个相同类型的Bean,通过@Qualifier来指定具体的Bean
    public CronTriggerFactoryBean cronTriggerBean(@Qualifier("detailFactoryBean1") MethodInvokingJobDetailFactoryBean detailFactoryBean) {
        //创建一个CronTriggerFactoryBean 触发器工厂对象
        CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
        //设置Cron表达式
        triggerFactory.setCronExpression("0/2 * * * * ?");      //每五秒执行一次，为触发器指定定时规则
        triggerFactory.setDescription("test1");                 //为触发器设置描述信息
        triggerFactory.setJobDetail(Objects.requireNonNull(detailFactoryBean.getObject()));         //为触发器设置定时任务,
        // 从detailFactoryBean得到对象
//        Objects.requireNonNull要求对象不为空 Objects用来处理空值的对象，
        return triggerFactory;
    }


    //触发器的Bean，为触发器设定触发任务条件 ，使用Cron表达式工厂的Bean
    @Bean(name = "cronTriggerBean2")               //有多个相同类型的Bean,通过@Qualifier来指定具体的Bean
    public CronTriggerFactoryBean cronTriggerBean2(@Qualifier("detailFactoryBean2") MethodInvokingJobDetailFactoryBean detailFactoryBean) {
        //创建一个CronTriggerFactoryBean 触发器工厂对象
        CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
        //设置Cron表达式
        triggerFactory.setCronExpression("0/5 * * * * ?");      //每五秒执行一次，为触发器指定定时规则
        triggerFactory.setDescription("test2");                 //为触发器设置描述信息
        triggerFactory.setJobDetail(Objects.requireNonNull(detailFactoryBean.getObject()));         //为触发器设置定时任务,
        // 从detailFactoryBean得到对象
//        Objects.requireNonNull要求对象不为空 Objects用来处理空值的对象，
        return triggerFactory;
    }

    //调度工厂的Bean,调度工厂执行任务

    @Bean
    public SchedulerFactoryBean schedulerFactory(@Qualifier("cronTriggerBean1") CronTrigger cronTrigger1, @Qualifier(
            "cronTriggerBean2") CronTrigger cronTrigger2) {
        //创建ScheduleFactoryBean对象
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
//        schedulerFactory.setJobDetails();这里也能指定具体的定时任务
        schedulerFactory.setTriggers(cronTrigger1, cronTrigger2);
        //给ScheduleFactory设置名字
        schedulerFactory.setSchedulerName("schedule1");
        return schedulerFactory;
    }
}

