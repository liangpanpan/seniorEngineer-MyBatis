package com.pp.ip;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.StringJoiner;

/**
 * 获取MAC地址工具类
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/19       create this file
 * </pre>
 */
public class MacUtil {
    private MacUtil() {
    }

    /**
     * 按照"XX-XX-XX-XX-XX-XX"格式，获取本机MAC地址
     *
     * @return
     * @throws Exception
     */
    public static List<String> getMacAddress() throws Exception {
        Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();

        List<String> macAddressList = new ArrayList<>();

        while (ni.hasMoreElements()) {
            NetworkInterface netI = ni.nextElement();

            if (netI == null) {
                continue;
            }

            byte[] bytes = netI.getHardwareAddress();
            if (netI.isUp() && bytes != null && bytes.length == 6) {
                StringJoiner sj = new StringJoiner("-");
                for (byte b : bytes) {
                    //与11110000作按位与运算以便读取当前字节高4位
                    String headPosition = Integer.toHexString((b & 240) >> 4);
                    //与00001111作按位与运算以便读取当前字节低4位
                    String lowPosition = Integer.toHexString(b & 15);

                    sj.add(headPosition + lowPosition);
                }
                macAddressList.add(sj.toString().toUpperCase());
            }
        }
        return macAddressList;
    }


    public static void main(String[] args) throws Exception {

        List<String> ipAddList = MacUtil.getMacAddress();
        Collections.sort(ipAddList);

        StringJoiner ipJoiner = new StringJoiner("|");
        ipAddList.stream().forEach(s -> ipJoiner.add(s));

        System.out.println(ipJoiner.toString());

    }

}