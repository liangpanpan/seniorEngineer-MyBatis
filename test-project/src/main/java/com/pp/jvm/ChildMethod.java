package com.pp.jvm;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/11       create this file
 * </pre>
 */
public class ChildMethod {

    public static void main(String[] args) {

        ChildMethod childMethod = new ChildMethod();
        childMethod.sayHello();


    }


    public void sayHello() {
        Boolean result = Boolean.TRUE;

        getResult(result);

        System.out.println(result);
    }

    private void getResult(Boolean result) {
        result = Boolean.TRUE;
    }

}
