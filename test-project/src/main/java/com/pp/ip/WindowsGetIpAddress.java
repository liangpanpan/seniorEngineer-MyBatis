package com.pp.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/19       create this file
 * </pre>
 */
public class WindowsGetIpAddress {

    public static void main(String[] args) throws UnknownHostException {

        // 网上反馈该代码只能在Windows上使用。并且该代码只能获取第一个网卡IP。
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: " + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);


    }

}
