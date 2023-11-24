package com.basic.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/7       create this file
 * </pre>
 */
public class JedisClusterTest {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(5);

        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("140.143.119.132", 8001));
        jedisClusterNode.add(new HostAndPort("140.143.119.132", 8002));
        jedisClusterNode.add(new HostAndPort("140.143.119.132", 8003));
        jedisClusterNode.add(new HostAndPort("140.143.119.132", 8004));
        jedisClusterNode.add(new HostAndPort("140.143.119.132", 8005));
        jedisClusterNode.add(new HostAndPort("140.143.119.132", 8006));

        JedisCluster jedisCluster = null;

        try {
            jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10,
                    "liangpan", config);
            System.out.println(jedisCluster.set("cluster", "zhuge"));
            System.out.println(jedisCluster.get("cluster"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedisCluster != null) {
                try {
                    jedisCluster.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
