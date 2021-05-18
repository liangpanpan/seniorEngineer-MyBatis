package com.pp.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/4/16       create this file
 * </pre>
 */
public class ListTest {

    public static void main(String[] args) {
        test01();
    }


    public static void test01() {
        List<String> bookList = new ArrayList<>();
        bookList.add("遥远的救世主");
        bookList.add("背叛");
        bookList.add("天幕红尘");
        bookList.add("人生");
        bookList.add("平凡的世界");

        List<String> luyaoBookList = bookList.subList(3, 5);

        System.out.println(bookList);
        System.out.println(luyaoBookList);

        // 往子集合中添加元素
        luyaoBookList.add("早晨从中午开始");

        System.out.println(bookList);
        System.out.println(luyaoBookList);
    }

}
