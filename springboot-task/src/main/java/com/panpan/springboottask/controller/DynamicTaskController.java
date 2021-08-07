package com.panpan.springboottask.controller;

import com.panpan.springboottask.service.AutoDownloadTask;
import com.panpan.springboottask.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/4       create this file
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class DynamicTaskController {
    @Resource
    private ThreadPoolTaskScheduler taskScheduler;

    @Resource
    private TaskService taskService;

    @Resource
    private AutoDownloadTask autoDownloadTask;

    private ScheduledFuture<?> scheduledFuture;

    @Value("${timing-task.cron1}")
    private String cronStr1;

    @Value("${timing-task.cron2}")
    private String cronStr2;


    @RequestMapping("/start")
    public String startTask(long microseconds) {

        // 延迟启动
        // Instant instant = Instant.now().atZone(ZoneId.of("Asia/Shanghai")).toInstant().plusMillis(microseconds);
        // scheduledFuture = taskScheduler.schedule(new RunTask01(), instant);

        // 第一次延迟后开始启动运行
        scheduledFuture = taskScheduler.schedule(new RunTask01(), new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cronStr1).nextExecutionTime(triggerContext);
            }
        });
        log.info("start timed task success ..");
        return "start task success";
    }

    @RequestMapping("/stop")
    public String stopTask() {
        Boolean result = null;
        if (scheduledFuture != null) {
            result = scheduledFuture.cancel(true);
        }
        log.info("stop timed task result: " + result);
        return "stop task result: " + result;
    }

    @RequestMapping("/modify")
    public String modifyTask() {
        Boolean stopResult = null;
        // 停止定时任务
        if (scheduledFuture != null) {
            stopResult = scheduledFuture.cancel(true);
        } else {
            log.info("modify task error -> scheduledFuture is null");
            return "error";
        }
        // 更换cron重新开启定时任务
        if (stopResult) {
            scheduledFuture = taskScheduler.schedule(new RunTask01(), new Trigger() {
                @Override
                public Date nextExecutionTime(TriggerContext triggerContext) {
                    return new CronTrigger(cronStr2).nextExecutionTime(triggerContext);
                }
            });
            log.info("modify task success ..");
            return "success";
        }
        log.info("modify task failed ..");
        return "failed";
    }

    @RequestMapping("/loopTaskStart")
    public String loopTaskStart(int flag) {
        // return taskService.taskStart(seconds);
        autoDownloadTask.addDownLoadTask(flag);
        return "Success";
    }

    @RequestMapping("/loopTaskCancel")
    public String loopTaskCancel() {
        autoDownloadTask.cancel();
        return "Success";
    }


    class RunTask01 implements Runnable {

        @Override
        public void run() {
            log.info("|schedule task01");
        }
    }

    class RunTask02 implements Runnable {
        @Override
        public void run() {
            log.info("|schedule task02");
        }
    }
}
