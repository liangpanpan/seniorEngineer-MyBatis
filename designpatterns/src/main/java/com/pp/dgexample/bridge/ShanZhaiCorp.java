package com.pp.dgexample.bridge;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class ShanZhaiCorp extends Corp {

    //产什么产品，不知道，等被调用的才知道
    public ShanZhaiCorp(Product product) {
        super(product);
    }

    //狂赚钱
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}
