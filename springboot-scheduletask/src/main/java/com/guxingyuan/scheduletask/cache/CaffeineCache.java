package com.guxingyuan.scheduletask.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.Scheduler;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;
import com.guxingyuan.scheduletask.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/1       create this file
 * </pre>
 */
@Configuration
public class CaffeineCache {

    private static final Logger logger = LoggerFactory.getLogger(CaffeineCache.class);

    private static Cache<String, User> userBoCache;

    private static final Interner<String> pool = Interners.newWeakInterner();

    @Bean
    public void initCaffeineCache() {
        userBoCache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .initialCapacity(10)
                .maximumSize(1000).scheduler(Scheduler.forScheduledExecutorService(Executors.newScheduledThreadPool(1)))
                .removalListener((String userId, User userInfo, RemovalCause cause) -> {
                    logger.info("cost userId:{}, userInfo:{}", userId, userInfo);
                })
                .build();
    }

    public boolean put(User user) {
        synchronized (pool.intern(user.getUserId())) {
            User userCache = get(user.getUserId());

            userCache.setUserId(user.getUserId());
            userCache.setAge(user.getAge());
            userCache.setUserName(user.getUserName());
            userCache.setInfo(user.getInfo());
            userCache.setNumber(userCache.getNumber() + user.getNumber());
        }
        return true;
    }

    public User get(String k) {
        return userBoCache.get(k, v -> new User());
    }

}
