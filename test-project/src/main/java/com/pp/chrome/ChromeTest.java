package com.pp.chrome;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * <pre>
 *  chrome下载地址为http://npm.taobao.org/mirrors/chromedriver/91.0.4472.19/
 *  当前使用的是91.0.4472.19/版本。
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/27       create this file
 * </pre>
 */
public class ChromeTest {

    public static void main(String[] args) throws IOException,
            InterruptedException {
        long time = System.currentTimeMillis();
        // 可省略，若驱动放在其他目录需指定驱动路径
        String fileName = "/chrome_driver/chromedriver.exe";
        String chromePath =
                ChromeTest.class.getClass().getResource("/").getPath();

        chromePath = chromePath + fileName;

        System.setProperty("webdriver.chrome.driver", chromePath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://baidu.com");
        // 休眠1s,为了让js执行完
        Thread.sleep(1000l);
        // 网页源码
        String source = driver.getPageSource();
        System.out.println(source);
        driver.close();
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }
}
