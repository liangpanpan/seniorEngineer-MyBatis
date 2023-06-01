package com.guxingyuan.scheduletask.controller;

import com.guxingyuan.scheduletask.cache.CaffeineCache;
import com.guxingyuan.scheduletask.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/1       create this file
 * </pre>
 */
@RestController
@RequestMapping(value = "userController")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private CaffeineCache caffeineCache;

    @RequestMapping(value = "addUser")
    public String addUser(@RequestBody User user) {
        if (user == null || user.getUserId() == null || "".equals(user.getUserId().trim())) {
            return "user is null";
        }
        logger.info("put use info to caffeine cache:{}", user);
        caffeineCache.put(user);
        return "finish";
    }

}
