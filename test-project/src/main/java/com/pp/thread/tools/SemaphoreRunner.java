package com.pp.thread.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/8/19       create this file
 * </pre>
 */
public class SemaphoreRunner {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new SemaphoreThread(semaphore).start();
        }

    }


    private static class SemaphoreThread extends Thread {

        private Semaphore semaphore;

        public SemaphoreThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            try {

                semaphore.acquire();
                if (semaphore.tryAcquire(1500, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() +
                            "runner");
                    Thread.sleep(2000);

                    semaphore.release();
                } else {
                    System.out.println(Thread.currentThread().getName() + "降级");
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
