package com.gc.dgmodel.command;

/**
 * 调用者角色
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public class Invoker {
    private Command command;

    //受气包，接受命令
    public void setCommand(Command _command) {
        this.command = _command;
    }

    //执行命令
    public void action() {
        this.command.execute();
    }
}
