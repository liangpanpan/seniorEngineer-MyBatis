package com.guxingyuan.quartz.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/7/14       create this file
 * </pre>
 */
@Service
public class QuartzService {

    private static final Logger logger = LoggerFactory.getLogger(QuartzService.class);

    public void test() {
        logger.info("Now Time" + new Date());
    }
}


