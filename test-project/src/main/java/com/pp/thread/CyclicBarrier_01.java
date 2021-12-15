package com.pp.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/11/1       create this file
 * </pre>
 */
public class CyclicBarrier_01 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10, () -> {
            System.out.println("10个线程已满，开始执行");
        });


        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    barrier.await();
                    // Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            }).start();
        }


    }
}
