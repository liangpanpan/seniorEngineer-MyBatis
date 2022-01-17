package com.gc.dgmodel.decorator;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component _component) {
        super(_component);
    }

    //定义自己的修饰方法
    private void method1() {
        System.out.println("method1 修饰");
    }

    //重写父类的Operation方法
    public void operate() {
        this.method1();
        super.operate();
    }
}
