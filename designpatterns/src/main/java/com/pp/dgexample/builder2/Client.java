package com.pp.dgexample.builder2;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class Client {

    public static void main(String[] args) {

        Person person = new Person.PersonBuilder().basicInfo(1, "name", 20)
                .weight(120).score(90).location("街道", "1801").builder();

    }
}
