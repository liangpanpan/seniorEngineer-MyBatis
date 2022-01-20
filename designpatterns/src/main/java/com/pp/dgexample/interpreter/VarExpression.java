package com.pp.dgexample.interpreter;

import java.util.HashMap;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/19       create this file
 * </pre>
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String _key) {
        this.key = _key;
    }

    //从map中取之
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
