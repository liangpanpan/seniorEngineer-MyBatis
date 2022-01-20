package com.gc.dgmodel.interpreter;

/**
 * —终结符表达式
 * 实现与文法中的元素相关联的解释操作，通常一个解释器模式中只有一个终结符表达式，但有多个实例，对应不同的终结符。
 * 具体到我们例子就是VarExpression类，表达式中的每个终结符都在栈中产生了一个VarExpression对象。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class TerminalExpression {
    //通常终结符表达式只有一个，但是有多个对象
    public Object interpreter(Context ctx) {
        return null;
    }
}
