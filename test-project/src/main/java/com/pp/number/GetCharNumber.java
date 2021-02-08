package com.pp.number;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/2/8       create this file
 * </pre>
 */
public class GetCharNumber {

    public static void main(String[] args) {

        // 第一个是G，也就是71
        // A 65, B 66, C
        int startNumber = 73;

        int regionNumber = 24;

        for (int i = 0; i < regionNumber; i++) {
            int result = startNumber + (i * 3);

            int num = 0;

            while (result > 90) {
                result = result - 26;
                num = num + 1;
            }

            char c = (char) result;

            String message = "";

            if (num > 0) {
                String start = "";
                if (num == 1) {
                    start = "A";
                } else if (num == 2) {
                    start = "B";
                } else if (num == 3) {
                    start = "C";
                }
                message = start + c + "";
            } else {
                message = c + "";
            }

            message = "=" + message + "4";

            if (i == (regionNumber - 1)) {
                System.out.print(message);
            } else {
                System.out.print(message + ",");
            }
        }

        //
        // int value = Integer.valueOf('A');
        // System.out.println(value);
        //
        // List<Integer> numberList = new ArrayList<>();
        //
        // for (int i = 0; i < 26 ; i ++) {
        //     numberList.add(65 + i);
        // }
        //
        // numberList.stream().forEach((num) -> {
        //     char c = (char) num.intValue();
        //     System.out.println(c);
        // });

    }


}
