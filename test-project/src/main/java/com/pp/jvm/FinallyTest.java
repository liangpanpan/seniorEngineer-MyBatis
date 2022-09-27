package com.pp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/3/31       create this file
 * </pre>
 */
public class FinallyTest {


    public int test01() {

        int i = 0;
        try {
            i++;
            System.out.println("当前Number:" + i);
            return i;
        } catch (Exception ex) {
            i++;
            System.out.println("catch Number:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally number" + i);
            return i;
        }

    }

    public List<String> test02() {
        List<String> resultList = new ArrayList<>();

        try {
            resultList.add("代码块添加内容");
            System.out.println("代码块:" + resultList.toString());
            return resultList;
        } catch (Exception ex) {
            resultList.add("异常块添加内容");
            System.out.println("异常块:" + resultList.toString());
            return resultList;
        } finally {
            resultList.add("最终结果finally块添加内容");
            System.out.println("最终结果finally块:" + resultList.toString());
            return resultList;
        }
    }

    public static void main(String[] args) {
        FinallyTest test = new FinallyTest();
        System.out.println("test01:" + test.test01());
        System.out.println("test02:" + test.test02());
    }

}
