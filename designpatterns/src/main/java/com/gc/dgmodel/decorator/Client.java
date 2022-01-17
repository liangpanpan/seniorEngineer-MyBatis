package com.gc.dgmodel.decorator;

/**
 * 装饰模式的使用场景
 * ● 需要扩展一个类的功能，或给一个类增加附加功能。
 * ● 需要动态地给一个对象增加功能，这些功能可以再动态地撤销。
 * ● 需要为一批的兄弟类进行改装或加装功能，当然是首选装饰模式。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}
