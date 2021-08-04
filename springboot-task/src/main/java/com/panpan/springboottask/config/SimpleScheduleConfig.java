package com.panpan.springboottask.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * 简单定时任务，在代码上进行的表达式cron配置
 * Cron表达式参数分别表示：
 * <p>
 * 秒（0~59） 例如0/5表示每5秒
 * 分（0~59）
 * 时（0~23）
 * 月的某天（0~31） 需计算
 * 月（0~11）
 * 周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
 * second（秒），minute（分），hour（时），day of month（月），month,day of week（周几）
 * 0 * * * * MON-FRI  周一到周五每一分钟启动一次
 * * * * * * MON-FRI  周一到周五每一分钟每一秒启动一次
 *
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/4       create this file
 * </pre>
 */
@Slf4j
// @Configuration //1.主要用于标记配置类，兼备Component的效果。
public class SimpleScheduleConfig {
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() throws InterruptedException {
        // 休眠8秒钟
        Thread.currentThread().sleep(8000);
        log.info("执行定时任务1: " + LocalDateTime.now());
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void task01() throws InterruptedException {
        log.info("task01 " + LocalDateTime.now());
        Thread.sleep(2000);
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void task02() {
        log.info("task02 " + LocalDateTime.now());
    }


}
