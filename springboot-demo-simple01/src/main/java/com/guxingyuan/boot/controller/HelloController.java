package com.guxingyuan.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/8       create this file
 * </pre>
 */
@RestController
public class HelloController {

    // 注入对象
    @Autowired
    private Environment env;

    // 注入配置
    @Value("${server.info}")
    private String info;

    @GetMapping("/getPort")
    public String hello() {

        String port = env.getProperty("server.info");
        return port;
    }
}
