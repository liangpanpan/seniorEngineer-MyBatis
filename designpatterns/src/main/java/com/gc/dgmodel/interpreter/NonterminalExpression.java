package com.gc.dgmodel.interpreter;

/**
 * 非终结符表达式
 * 文法中的每条规则对应于一个非终结表达式，具体到我们的例子就是加减法规则分别对应到AddExpression和SubExpression两个类。
 * 非终结符表达式根据逻辑的复杂程度而增加，原则上每个文法规则都对应一个非终结符表达式。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class NonterminalExpression extends Expression {
    //每个非终结符表达式都会对其他表达式产生依赖
    public NonterminalExpression(Expression... expression) {
    }

    public Object interpreter(Context ctx) {
        //进行文法处理
        return null;
    }

}
