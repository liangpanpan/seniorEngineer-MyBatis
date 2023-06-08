package com.pp.dgexample.lsp;

import java.util.HashMap;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/7       create this file
 * </pre>
 */
public class Client {

    public static void main(String[] args) {

        Son son = new Son();

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        son.doSomething(map);
    }

}
