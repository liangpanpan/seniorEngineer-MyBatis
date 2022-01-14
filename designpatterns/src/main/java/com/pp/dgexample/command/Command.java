package com.pp.dgexample.command;

/**
 * 抽象命令类
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public abstract class Command {

    //把三个组都定义好，子类可以直接使用
    protected RequirementGroup rg = new RequirementGroup();  //需求组
    protected PageGroup pg = new PageGroup();  //美工组
    protected CodeGroup cg = new CodeGroup();  //代码组


    public abstract void execute();
}
