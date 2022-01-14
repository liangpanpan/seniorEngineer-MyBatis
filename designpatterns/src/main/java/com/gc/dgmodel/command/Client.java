package com.gc.dgmodel.command;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public class Client {
    public static void main(String[] args) {
        //首先声明调用者Invoker
        Invoker invoker = new Invoker();
        //定义接收者
        Receiver receiver = new ConcreteReceiver1();
        //定义一个发送给接收者的命令
        Command command = new ConcreteCommand1(receiver);
        //把命令交给调用者去执行
        invoker.setCommand(command);
        invoker.action();

        // 优化二
        //定义一个发送给接收者的命令
        Command command2 = new ConcreteCommand2();
        //把命令交给调用者去执行
        invoker.setCommand(command2);
        invoker.action();
    }
}
