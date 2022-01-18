package com.gc.dgmodel.state;

/**
 * 抽象状态角色
 * 接口或抽象类，负责对象状态定义，并且封装环境角色以实现状态切换。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public abstract class State {
    //定义一个环境角色，提供子类访问
    protected Context context;

    //设置环境角色
    public void setContext(Context _context) {
        this.context = _context;
    }

    //行为1
    public abstract void handle1();

    //行为2
    public abstract void handle2();

}
