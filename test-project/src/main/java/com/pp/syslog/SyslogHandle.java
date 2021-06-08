package com.pp.syslog;

import org.graylog2.syslog4j.server.SyslogServerEventIF;
import org.graylog2.syslog4j.server.SyslogServerIF;
import org.graylog2.syslog4j.server.SyslogServerSessionEventHandlerIF;

import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class SyslogHandle implements SyslogServerSessionEventHandlerIF {
    @Override
    public Object sessionOpened(SyslogServerIF syslogServer,
                                SocketAddress socketAddress) {
        return null;
    }

    @Override
    public void event(Object session, SyslogServerIF syslogServer,
                      SocketAddress socketAddress, SyslogServerEventIF event) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println(sdf.format(new Date()) + " receive from:" + socketAddress
                + event.getHost() +
                "\tmessage" + event.getMessage());
    }

    @Override
    public void exception(Object session, SyslogServerIF syslogServer,
                          SocketAddress socketAddress, Exception exception) {

    }

    @Override
    public void sessionClosed(Object session, SyslogServerIF syslogServer,
                              SocketAddress socketAddress, boolean timeout) {

    }

    @Override
    public void initialize(SyslogServerIF syslogServer) {

    }

    @Override
    public void destroy(SyslogServerIF syslogServer) {

    }
}
