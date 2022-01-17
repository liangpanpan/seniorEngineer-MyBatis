package com.gc.dgmodel.strategy;

/**
 * 多个类只有在算法或行为上稍有不同的场景。
 * ● 算法需要自由切换的场景。
 * 例如，算法的选择是由使用者决定的，或者算法始终在进化，特别是一些站在技术前沿的行业，连业务专家都无法给你保证这样的系统规则能够存在多长时间，在这种情况下策略模式是你最好的助手。
 * ● 需要屏蔽算法规则的场景。
 * 现在的科技发展得很快，人脑的记忆是有限的（就目前来说是有限的），太多的算法你只要知道一个名字就可以了，传递相关的数字进来，反馈一个运算结果，万事大吉。
 * <p>
 * 如果系统中的一个策略家族的具体策略数量超过4个，则需要考虑使用混合模式，解决策略类膨胀和对外暴露的问题，否则日后的系统维护就会成为一个烫手山芋，谁都不想接。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/17       create this file
 * </pre>
 */
public class Client {

    public static void main(String[] args) {
        //声明一个具体的策略
        Strategy strategy = new ConcreteStrategy1();
        //声明上下文对象
        Context context = new Context(strategy);
        //执行封装后的方法
        context.doAnything();
    }

}
