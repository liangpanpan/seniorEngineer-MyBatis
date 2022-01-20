package com.gc.dgmodel.flyweight;

/**
 * 具体的亨元角色
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class ConcreteFlyweight1 extends Flyweight {

    //接受外部状态
    public ConcreteFlyweight1(String _Extrinsic) {
        super(_Extrinsic);
    }

    //根据外部状态进行逻辑处理
    public void operate() {
        //业务逻辑
    }
}
