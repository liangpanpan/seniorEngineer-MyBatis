package com.guxingyuan.scheduletask.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.codec.CodecException;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/4/27       create this file
 * </pre>
 */
@Component
@Order(value = 10)
public class CacheRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(1000 * 10);
        if (args == null) {
            throw new CodecException("args is null");
        }
        if (1 == 1) {
            throw new CodecException("test exception");
        }
    }
}
