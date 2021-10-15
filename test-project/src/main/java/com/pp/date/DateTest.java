package com.pp.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/10/9       create this file
 * </pre>
 */
public class DateTest {

    @Test
    public void printFormatDateTime() {

        Date nowDate = Calendar.getInstance(TimeZone.getDefault()).getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");

        System.out.println(sdf.format(nowDate));
    }

    @Test
    public void convertTime() throws ParseException {
        String timeStr = "2021-10-14T01:42:25Z";

        String FORMAT_OF_UTC = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_OF_UTC);
        Date date = sdf.parse(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 8);


        long timeLong = calendar.getTimeInMillis() / 1000;
        System.out.println(timeLong);
    }

    @Test
    public void getTime() {
        long time = 1634266669;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));

    }

}
