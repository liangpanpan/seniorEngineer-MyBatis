package com.gc.dgmodel.flyweight;

/**
 * 抽象享元角色
 * 它简单地说就是一个产品的抽象类，同时定义出对象的外部状态和内部状态的接口或实现。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public abstract class Flyweight {

    //内部状态
    private String intrinsic;
    //外部状态
    protected final String Extrinsic;

    //要求享元角色必须接受外部状态
    public Flyweight(String _Extrinsic) {
        this.Extrinsic = _Extrinsic;
    }

    //定义业务操作
    public abstract void operate();

    //内部状态的getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
