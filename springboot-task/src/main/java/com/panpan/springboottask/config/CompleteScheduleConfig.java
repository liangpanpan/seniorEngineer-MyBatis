package com.panpan.springboottask.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * 从数据库中读取定时任务配置策略，修改完数据库配置信息后可以，定时任务会响应修改
 * <p>
 * 存在一个问题，就是假如当前数据库中设置的下一次任务时间过长，期望调整一下，必须等到下一次任务执行完后才能生效。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/4       create this file
 * </pre>
 */
@Slf4j
// @Configuration
public class CompleteScheduleConfig implements SchedulingConfigurer {

    @Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        String getCron();
    }

    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;

    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        // 该策略不能设置的过小，否则更改数据库后无法执行下一次任务
        String defaultCron = "0/1 * * * * ?";

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    log.info("执行定时任务2: " + LocalDateTime.now().toLocalTime());
                    String cron = cronMapper.getCron();
                    if (StringUtils.isEmpty(cron)) {
                        log.info("未设置定时任务时间，不进行执行");
                        return;
                    }

                    log.info("开始执行任务");
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                        // 不能返回null,否则下次就将不再执行
                        cron = defaultCron;
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
