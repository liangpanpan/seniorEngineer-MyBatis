package com.guxingyuan.quartz.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/7/14       create this file
 * </pre>
 */
//加入到spring容器中
@Service
@Slf4j
public class QuartzService {

    //定时任务一，若为单任务，则执行第一个任务
    public void test1() {
        log.info("Now Time: " + new Date());
    }

    //定时任务二
    public void test2() {
        log.info("当前时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

