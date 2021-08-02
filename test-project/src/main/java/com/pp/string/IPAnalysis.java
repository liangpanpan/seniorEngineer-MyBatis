package com.pp.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/7/29       create this file
 * </pre>
 */
public class IPAnalysis {

    public static void main(String[] args) {

        IPAnalysis ipAnalysis = new IPAnalysis();

        String intranet = "192.168.0.0/16\n" +
                "127.0.0.1\n" +
                "10.1.0.0/16\n" +
                "172.168.0.0/16\n" +
                "172.16.0.0/16\n172.19.64.0/22";

        // intranet = "172.19.64.0/22";

        String[] intranets = intranet.split("\n");
        List<String> resultList = new ArrayList<>();
        for (String netIp : intranets) {
            resultList.addAll(ipAnalysis.analysisToIPParagraph(netIp));
        }

        for (String result : resultList) {
            System.out.println(result);
        }

        // System.out.println(resultList);
    }


    private List<String> analysisToIPParagraph(String ipParagraph) {
        // 按照/分解
        String[] ipParas = ipParagraph.split("/");

        List<String> tempList = new ArrayList<>();
        // 判断是否包含/
        if (ipParas.length < 2) {
            tempList.add(ipParagraph);
            return tempList;
        }

        // 转换掩码为integer
        int mask = Integer.valueOf(ipParas[1]);

        if (mask == 32) {
            tempList.add(ipParagraph);
            return tempList;
        }

        // 分解IP成数字
        String[] ipNums = ipParas[0].split("\\.");

        int ip1 = Integer.valueOf(ipNums[0]);
        int ip2 = Integer.valueOf(ipNums[1]);
        int ip3 = Integer.valueOf(ipNums[2]);
        int ip4 = Integer.valueOf(ipNums[3]);

        mask = Integer.valueOf(ipParas[1]);
        int[] maskNums = getMaskNums(mask);


        int firstAdr1 = ip1 & maskNums[0];
        int firstAdr2 = ip2 & maskNums[1];
        int firstAdr3 = ip3 & maskNums[2];
        int firstAdr4 = ip4 & maskNums[3];

        int lastAdr1 = ip1 | (~maskNums[0] & 0xff);
        int lastAdr2 = ip2 | (~maskNums[1] & 0xff);
        int lastAdr3 = ip3 | (~maskNums[2] & 0xff);
        int lastAdr4 = ip4 | (~maskNums[3] & 0xff);

        // 判断最后的是否为255
        if (lastAdr4 != 255) {
            // 从firstAdr4开始循环到最后的lastAdr4
            for (int index = firstAdr4; index <= lastAdr4; index++) {
                StringJoiner joiner = new StringJoiner(".");
                joiner.add(firstAdr1 + "");
                joiner.add(firstAdr2 + "");
                joiner.add(firstAdr3 + "");
                joiner.add(index + "");

                tempList.add(joiner.toString());
            }
            return tempList;
        }

        if (lastAdr3 != 255) {
            // 从firstAdr4开始循环到最后的lastAdr4
            for (int index = firstAdr3; index <= lastAdr3; index++) {
                StringJoiner joiner = new StringJoiner(".");
                joiner.add(firstAdr1 + "");
                joiner.add(firstAdr2 + "");
                joiner.add(index + "");
                tempList.add(joiner.toString() + ".");
            }
            return tempList;
        }

        if (lastAdr2 != 255) {
            // 从firstAdr2开始循环到最后的lastAdr2
            for (int index = firstAdr2; index <= lastAdr2; index++) {
                StringJoiner joiner = new StringJoiner(".");
                joiner.add(firstAdr1 + "");
                joiner.add(index + "");
                tempList.add(joiner.toString() + ".");
            }
            return tempList;
        }

        if (lastAdr1 != 255) {
            // 从firstAdr2开始循环到最后的lastAdr2
            for (int index = firstAdr1; index <= lastAdr1; index++) {
                StringJoiner joiner = new StringJoiner(".");
                joiner.add(index + "");
                tempList.add(joiner.toString() + ".");
            }
            return tempList;
        }

        return tempList;

        //
        // StringJoiner joiner = new StringJoiner(".");
        // joiner.add(firstAdr1 + "");
        // joiner.add(firstAdr2 + "");
        // joiner.add(firstAdr3 + "");
        // joiner.add(firstAdr4 + "");
        //
        // tempList.add(joiner.toString());
        //
        // joiner = new StringJoiner(".");
        // joiner.add(lastAdr1 + "");
        // joiner.add(lastAdr2 + "");
        // joiner.add(lastAdr3 + "");
        // joiner.add(lastAdr4 + "");
        // tempList.add(joiner.toString());
    }

    /**
     * 计算掩码
     *
     * @param mask
     * @return
     */
    private int[] getMaskNums(int mask) {
        // 计算
        int[] masks = new int[4];

        if (mask >= 8) {
            masks[0] = 255;
            mask = mask - 8;
        } else {
            masks[0] = fillbitsfromleft(mask);
            return masks;
        }

        if (mask >= 8) {
            masks[1] = 255;
            mask = mask - 8;
        } else {
            masks[1] = fillbitsfromleft(mask);
            return masks;
        }

        if (mask >= 8) {
            masks[2] = 255;
            mask = mask - 8;
        } else {
            masks[2] = fillbitsfromleft(mask);
            return masks;
        }

        masks[3] = fillbitsfromleft(mask);
        return masks;
    }

    private int fillbitsfromleft(int value) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int index = 0; index < value; index++) {
            resultBuilder.append("1");
        }
        int lastNub = 8 - value;
        for (int index = 0; index < lastNub; index++) {
            resultBuilder.append("0");
        }
        // 将二进制字符串转换成十进制
        long scale2Decimal = scale2Decimal(resultBuilder.toString(), 2);
        return Long.valueOf(scale2Decimal).intValue();
    }

    public static long scale2Decimal(String number, int scale) {
        checkNumber(number);
        if (2 > scale || scale > 32) {
            throw new IllegalArgumentException("scale is not in range");
        }
        // 不同其他进制转十进制,修改这里即可
        long total = 0L;
        String[] ch = number.split("");
        int chLength = ch.length;
        for (int i = 0; i < chLength; i++) {
            total += Integer.valueOf(ch[i]) * Math.pow(scale, chLength - 1 - i);
        }
        return total;
    }

    /**
     * 判断字符是否为数字，不是数字抛出异常
     *
     * @param number
     */
    public static void checkNumber(String number) {
        String regexp = "^\\d+$";
        if (null == number || !number.matches(regexp)) {
            throw new IllegalArgumentException("input is not a number");
        }
    }

}
