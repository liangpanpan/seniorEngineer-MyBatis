package com.guxingyuan.jdbc.dao;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/8/24       create this file
 * </pre>
 */
@SpringBootTest
public class RedisDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisDaoTest.class);

    @Resource
    RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis() {
        String key = "key_111_";
        logger.info("start redis");

        for (int i = 0; i < 5; i++) {
            String redisKey = key + i;
            String value = key + i + "_aaa";
            redisTemplate.opsForValue().set(redisKey, value);
            logger.info("set redisKey:{} value:{} to redis", redisKey, value);
        }

        for (int i = 0; i < 5; i++) {
            String value = redisTemplate.opsForValue().get(key + i);
            logger.info("get value from redis:{}", value);
        }
    }
}
