package com.panpan.bootwar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/12/8       create this file
 * </pre>
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(value = "/sayHello")
    @ResponseBody  // 添加该信息可以返回JSON对象
    public String hello(String message) {

        return "hello Message is :" + message;
    }
}
