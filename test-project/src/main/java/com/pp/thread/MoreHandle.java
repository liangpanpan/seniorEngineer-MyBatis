package com.pp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这个类是想实现先往一个list中放随机生成的数据，然后启动两个线程，将list分组进行处理，
 * 线程处理的逻辑是将随机数+1，放在一个统一个Map中，最后进行打印
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/3       create this file
 * </pre>
 */

public class MoreHandle {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(500);

        // 对该list生成随机数赋值
        randomNumber(integerList, 500);

        // 对list进行分组，每个组100个内容
        Map<Integer, Integer> resultMap = new ConcurrentHashMap<>();

        List<Thread> threadList = new ArrayList<>();

        for (List<Integer> integers : splitList(integerList, 100)) {

            Thread thread = new MatchThread(integers, resultMap);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("所有线程执行完毕，size：" + resultMap.size());

        for (Map.Entry<Integer, Integer> integerIntegerEntry :
                resultMap.entrySet()) {
            System.out.println("Key:" + integerIntegerEntry.getKey() + " " +
                    "value:" + integerIntegerEntry.getValue());
        }
    }


    static class MatchThread extends Thread {

        private List<Integer> list;
        private Map<Integer, Integer> map;

        public MatchThread(List<Integer> list, Map<Integer, Integer> map) {
            this.list = list;
            this.map = map;
        }

        @Override
        public void run() {

            for (Integer integer : list) {

                int sleepTime = new Random().nextInt(100);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(integer, integer + 1);
            }

            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }
    }

    private static List<List<Integer>> splitList(List<Integer> list,
                                                 int splitNumber) {

        int endIndex = 0;
        int startIndex;

        List<List<Integer>> resultGroupList = new ArrayList<>();

        do {

            startIndex = endIndex;
            int tempIndex = endIndex + splitNumber;
            endIndex = tempIndex > list.size() ? list.size() : tempIndex;

            List<Integer> accountNumberList = list.subList(startIndex,
                    endIndex);
            resultGroupList.add(accountNumberList);

        } while (endIndex < list.size());

        return resultGroupList;

    }


    private static void randomNumber(List<Integer> integerList, int number) {
        for (int i = 0; i < number; i++) {
            Random random = new Random();
            // integerList.add(random.nextInt(100));
            integerList.add(i);
        }
    }

}
