package com.pp.string;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/6/25       create this file
 * </pre>
 */
public class StringFormatTest {

    public static void main(String[] args) {

        String message = "12312{0}31312{1}3121212123";


        System.out.println(MessageFormat.format(message, "number1", "aaa"));

        System.out.println(Boolean.valueOf("0"));


        String ss = "10|127|192";
        System.out.println(Arrays.asList(ss.split("\\|")));

        String ip = "172.0.0.0";

        int index = ip.indexOf(".0.");

        System.out.println(ip.substring(0, index) + ".");


        String intranet = "192.168.0.0/16\n" +
                "127.0.0.1\n" +
                "10.1.0.0/16\n" +
                "172.168.0.0/16\n" +
                "172.16.0.0/16";


        String replaceTest = "11,22,33";
        System.out.println(replaceTest.replace(",", "，"));


    }
}
