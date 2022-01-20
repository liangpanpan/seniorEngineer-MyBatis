package com.pp.dgexample.interpreter;

import java.util.HashMap;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    //左右两个表达式相减
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
