package com.guxingyuan.boot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *  处理Redis操作
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/16       create this file
 * </pre>
 */
@Component
public class MyRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;


}
