package com.pp.syslog;

import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.server.SyslogServer;
import org.graylog2.syslog4j.server.SyslogServerIF;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/5/20       create this file
 * </pre>
 */
public class SyslogTest {
    public static void main(String[] args) throws InterruptedException {
        SyslogServerIF threadedInstance =
                SyslogServer.getThreadedInstance(SyslogConstants.UDP);
        threadedInstance.getConfig().setPort(514);
        threadedInstance.getConfig().addEventHandler(new SyslogHandle());

        threadedInstance.getThread().join();
        System.out.println("finish");

    }
}
