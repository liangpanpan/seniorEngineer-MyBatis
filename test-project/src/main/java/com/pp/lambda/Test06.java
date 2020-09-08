package com.pp.lambda;

import java.util.function.Consumer;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/9/3       create this file
 * </pre>
 */
public class Test06 {

    public static void main(String[] args) {

        consumer("麻黄", something -> {
            System.out.println(something + "烫一碗");
        });


        doubleConsumer("麻黄",
                something -> System.out.println("华佗用" + something + "开出："),
                something -> System.out.println(something + "烫一碗"));

    }

    private static void consumer(String something, Consumer<String> consumer) {
        consumer.accept(something);
    }

    private static void doubleConsumer(String something,
                                       Consumer<String> consumer1,
                                       Consumer<String> consumer2) {
        consumer1.andThen(consumer2).accept(something);
    }


}
