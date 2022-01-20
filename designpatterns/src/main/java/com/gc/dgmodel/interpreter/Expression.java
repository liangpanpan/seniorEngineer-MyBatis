package com.gc.dgmodel.interpreter;

/**
 * 抽象表达式
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public abstract class Expression {
    //每个表达式必须有一个解析任务
    public abstract Object interpreter(Context ctx);

}
