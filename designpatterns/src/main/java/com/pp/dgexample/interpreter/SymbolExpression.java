package com.pp.dgexample.interpreter;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public abstract class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    //所有的解析公式都应只关心自己左右两个表达式的结果
    public SymbolExpression(Expression _left, Expression _right) {
        this.left = _left;
        this.right = _right;
    }
}
