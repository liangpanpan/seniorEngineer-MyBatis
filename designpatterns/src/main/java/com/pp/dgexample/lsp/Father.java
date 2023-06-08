package com.pp.dgexample.lsp;

import java.util.Collection;
import java.util.HashMap;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/7       create this file
 * </pre>
 */
public class Father {

    public Collection doSomething(HashMap map) {
        System.out.println("父类执行中");
        return map.values();
    }
}
