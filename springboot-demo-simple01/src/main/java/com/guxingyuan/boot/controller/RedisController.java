package com.guxingyuan.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/5       create this file
 * </pre>
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping(value = "/setRedisInof")
    public String setOneRedisInfo(@RequestParam String redisKey, String redisInfo) {
        redisTemplate.opsForValue().set(redisKey, redisInfo);
        return "ok";
    }


}
