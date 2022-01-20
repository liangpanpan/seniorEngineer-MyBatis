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
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    //把左右两个表达式运算的结果加起来
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }

}
