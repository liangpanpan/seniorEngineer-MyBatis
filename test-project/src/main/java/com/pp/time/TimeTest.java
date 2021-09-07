package com.pp.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/9/3       create this file
 * </pre>
 */
public class TimeTest {

    /**
     * 不符合格式要求的，可以使用两个''包裹起来
     */
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日' EEE HH'时'mm'分'ss'秒' 'CST'",
            Locale.CHINA);

    public static void main(String[] args) {

        Long timeLong = 1725206399000L;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeLong);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));

        //


    }

}
