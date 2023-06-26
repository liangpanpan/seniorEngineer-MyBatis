package com.pp.pcap;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/3/24       create this file
 * </pre>
 */
public class JnetApp {

    public static void main(String[] args) {

        List<PcapIf> devs = new ArrayList<>();
        StringBuilder errsb = new StringBuilder();
        int r = Pcap.findAllDevs(devs, errsb);
        if (r != Pcap.OK || devs.isEmpty()) {
            System.err.println("未获取到网卡");
        } else {
            System.out.println("获取到网卡：");
            System.out.println(devs);
        }
    }
}
