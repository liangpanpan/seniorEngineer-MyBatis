package com.pp.syslog;

import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.server.SyslogServer;
import org.graylog2.syslog4j.server.SyslogServerConfigIF;
import org.graylog2.syslog4j.server.SyslogServerEventIF;
import org.graylog2.syslog4j.server.SyslogServerIF;
import org.graylog2.syslog4j.server.SyslogServerSessionEventHandlerIF;

import java.net.SocketAddress;

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
public class SyslogReveiver {

    private static final int PORT = 514;

    private void receiveSyslogMessage() throws InterruptedException {


        SyslogServerIF server = SyslogServer.getInstance(SyslogConstants.UDP);
        SyslogServerConfigIF config = server.getConfig();
        // config.setHost(HOST);
        config.setPort(PORT);
        config.addEventHandler(new SyslogServerSessionEventHandlerIF() {
            @Override
            public Object sessionOpened(SyslogServerIF syslogServerIF,
                                        SocketAddress socketAddress) {
                return null;
            }

            @Override
            public void event(Object o, SyslogServerIF syslogServerIF,
                              SocketAddress socketAddress,
                              SyslogServerEventIF syslogServerEventIF) {
                System.out.println("receive from:" + socketAddress +
                        "\tmessage" + syslogServerEventIF.getMessage());
            }

            @Override
            public void exception(Object o, SyslogServerIF syslogServerIF,
                                  SocketAddress socketAddress, Exception e) {

            }

            @Override
            public void sessionClosed(Object o, SyslogServerIF syslogServerIF
                    , SocketAddress socketAddress, boolean b) {

            }

            @Override
            public void initialize(SyslogServerIF syslogServerIF) {

            }

            @Override
            public void destroy(SyslogServerIF syslogServerIF) {

            }
        });
        SyslogServer.getThreadedInstance(SyslogConstants.UDP);
        Thread.sleep(100000);
    }


    public static void main(String[] args) throws InterruptedException {
        new SyslogReveiver().receiveSyslogMessage();
    }
}
