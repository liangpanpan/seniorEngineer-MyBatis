package com.gc.dgmodel.facade;

/**
 * （要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。
 * 门面类不能参与子系统的业务逻辑。即一个接口只能调用a对象的一个或者几个方法，不能访问a和b，否则就继续扩展一个封装类
 * <p>
 * 门面模式是一个很好的封装方法，一个子系统比较复杂时，比如算法或者业务比较复杂，就可以封装出一个或多个门面出来，项目的结构简单，而且扩展性非常好。
 * 还有，对于一个较大项目，为了避免人员带来的风险，也可以使用门面模式，技术水平比较差的成员，尽量安排独立的模块，然后把他写的程序封装到一个门面里，
 * 尽量让其他项目成员不用看到这些人的代码，看也看不懂，我也遇到过一个“高人”写的代码，private方法、构造函数、常量基本都不用，你要一个public方法，
 * 好，一个类里就一个public方法，所有代码都在里面，然后你就看吧，一大坨程序，看着就能把人逼疯。使用门面模式后，对门面进行单元测试，
 * 约束项目成员的代码质量，对项目整体质量的提升也是一个比较好的帮助。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class Facade {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();

    //提供给外部访问的方法
    public void methodA() {
        this.a.doSomethingA();
    }

    public void methodB() {
        this.b.doSomethingB();
    }

    public void methodC() {
        this.c.doSomethingC();
    }
}
