package com.pp.thread;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/12/17       create this file
 * </pre>
 */
public class TestNativeOutOfMemoryError {
    public static void main(String[] args) {

        for (int i = 0; ; i++) {
            System.out.println("i = " + i);
            new Thread(new HoldThread()).start();
        }
    }

}

class HoldThread extends Thread {
    CountDownLatch cdl = new CountDownLatch(1);

    private static String[] contents = new String[10000];

    static {
        for (int i = 0; i < 10000; i++) {
            contents[i] = "1234567890";
        }
    }

    public HoldThread() {
        this.setDaemon(true);
    }

    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
    }
}
