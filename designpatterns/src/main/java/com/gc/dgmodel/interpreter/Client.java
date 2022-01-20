package com.gc.dgmodel.interpreter;

import java.util.Stack;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class Client {

    public static void main(String[] args) {
        Context ctx = new Context();
        //通常定一个语法容器，容纳一个具体的表达式，通常为ListArray、LinkedList、Stack等类型
        Stack<Expression> stack = new Stack<>();
        // for(;;){
        //     //进行语法判断，并产生递归调用
        // }
        //产生一个完整的语法树，由各个具体的语法分析进行解析
        Expression exp = stack.pop();
        //具体元素进入场景
        exp.interpreter(ctx);
    }
}