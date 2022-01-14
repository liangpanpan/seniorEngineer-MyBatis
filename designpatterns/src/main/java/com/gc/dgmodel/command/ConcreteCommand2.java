package com.gc.dgmodel.command;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public class ConcreteCommand2 extends Command {

    public ConcreteCommand2() {
        super(new ConcreteReceiver1());
    }

    //设置新的接收者
    public ConcreteCommand2(Receiver _receiver) {
        super(_receiver);
    }

    //必须实现一个命令
    public void execute() {
        //业务处理
        this.receiver.doSomething();
    }
}

