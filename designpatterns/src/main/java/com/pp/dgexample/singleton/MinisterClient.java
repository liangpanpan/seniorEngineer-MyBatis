package com.pp.dgexample.singleton;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class MinisterClient {
    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            Emperor.say();
        }
        //三天见的皇帝都是同一个人，荣幸吧！
    }
}
