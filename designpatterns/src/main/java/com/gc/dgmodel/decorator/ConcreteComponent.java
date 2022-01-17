package com.gc.dgmodel.decorator;

/**
 * ConcreteComponent是最核心、最原始、最基本的接口或抽象类的实现，你要装饰的就是它。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class ConcreteComponent extends Component {

    @Override
    void operate() {
        System.out.println("do Something");
    }
}
