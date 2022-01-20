package com.pp.dgexample.bridge;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class HouseCorp extends Corp {

    //定义传递一个House产品进来
    public HouseCorp(House house) {
        super(house);
    }

    //房地产公司很High了，赚钱，计算利润
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
