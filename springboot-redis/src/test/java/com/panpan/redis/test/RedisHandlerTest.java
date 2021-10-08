package com.panpan.redis.test;

import com.panpan.redis.RedisApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/10/8       create this file
 * </pre>
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisHandlerTest {

    String key = "flow:alarmcounts:tableName:attack_ip";

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testIncrementScore() {


        String attackIp = "192.168.10.12";

        long startTime = System.currentTimeMillis();
        Double aDouble = redisTemplate.opsForZSet().incrementScore(key, attackIp, 1);
        long endTime = System.currentTimeMillis();

        log.info("cost time {}", (endTime - startTime));

        log.info("incrementScore {} result {}", attackIp, aDouble);
        Assert.assertTrue(aDouble > 0);

    }

    @Test
    public void testIncrementScore1() {

        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        long startTime = System.currentTimeMillis();

        Set<ZSetOperations.TypedTuple> set = zSetOperations.reverseRangeByScoreWithScores(key, 0,
                Double.MAX_VALUE, 0, 5);

        long endTime = System.currentTimeMillis();

        log.info("cost time {}", (endTime - startTime));

        set.stream().forEach(s -> log.info("value:{}, score:{}", s.getValue(), s.getScore()));

    }

}
