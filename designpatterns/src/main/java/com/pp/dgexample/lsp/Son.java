package com.pp.dgexample.lsp;

import java.util.Collection;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/6/7       create this file
 * </pre>
 */
public class Son extends Father {

    public Collection doSomething(Map map) {
        System.out.println("子类执行中");
        return map.values();
    }
}
