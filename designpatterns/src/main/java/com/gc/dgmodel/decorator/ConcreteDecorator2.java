package com.gc.dgmodel.decorator;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component _component) {
        super(_component);
    }

    //定义自己的修饰方法
    private void method2() {
        System.out.println("method2 修饰");
    }

    //重写父类的Operation方法
    public void operate() {
        this.method2();
        super.operate();
    }
}
