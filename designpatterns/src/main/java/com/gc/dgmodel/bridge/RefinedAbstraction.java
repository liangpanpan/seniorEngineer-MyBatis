package com.gc.dgmodel.bridge;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class RefinedAbstraction extends Abstraction {
    //覆写构造函数
    public RefinedAbstraction(Implementor _imp) {
        super(_imp);
    }

    //修正父类的行为
    @Override
    public void request() {
        /*
         * 业务处理...
         */
        super.request();
        super.getImp().doAnything();
    }

}
