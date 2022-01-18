package com.pp.dgexample.visitor;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public interface IVisitor {
    //首先，定义我可以访问普通员工
    void visit(CommonEmployee commonEmployee);

    //其次，定义我还可以访问部门经理
    void visit(Manager manager);
}
