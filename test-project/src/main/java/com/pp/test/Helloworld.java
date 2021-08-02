package com.pp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description TODO
 * @Author thinkpad
 * @Date 2020/3/7 10:16
 */
public class Helloworld {
    public static void main(String[] args) throws ParseException {
        System.out.println("hello world, this is my project.");
        System.out.println("22221");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());


        calendar.add(Calendar.MINUTE, -10);

        String dataStr = "2021-06-18 01:51:06";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd " +
                "HH:mm:ss");

        calendar.setTime(simpleDateFormat.parse(dataStr));

        System.out.println(simpleDateFormat.format(calendar.getTime()));
        System.out.println(calendar.getTime().getTime());
    }
}
