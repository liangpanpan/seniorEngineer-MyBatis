package com.pp.thread;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/8/6       create this file
 * </pre>
 */
public class Jmm03_CodeVisibility {

    public static Boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main start");

        Thread threadA = new Thread(() -> {
            while (!initFlag) {
                System.out.println("a");
            }

            System.out.println("threadA finish");
        }, "threadA");

        threadA.start();
        Thread.sleep(500);

        Thread threadB = new Thread(() -> {
            System.out.println("start change initFlag is true");
            initFlag = true;
            System.out.println("finish change initFlag to true");
        }, "threadB");

        threadB.start();


    }

}
