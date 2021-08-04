package com.panpan.springboottask.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/4       create this file
 * </pre>
 */
@Slf4j
@Service
public class TaskService {

    BeatReactor beatReactor;

    public TaskService() {
        beatReactor = new BeatReactor();
    }

    @Async("asyncServiceExecutor")
    public String taskStart(long second) throws InterruptedException {

        log.info("taskStart");
        beatReactor.addBeatInfo(second);
        //延迟1秒启动，每1秒执行一次
        return "success";
    }

    public String cancel() {
        beatReactor.cancel();
        return "cancel success";
    }
}
