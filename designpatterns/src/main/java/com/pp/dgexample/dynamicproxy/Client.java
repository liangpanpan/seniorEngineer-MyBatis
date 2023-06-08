package com.pp.dgexample.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class Client {

    public static void main(String[] args) {
        //定义一个痴迷的玩家
        IGamePlayer player = new GamePlayer("张三");
        //定义一个handler
        InvocationHandler handler = new GamePlayIH(player);
        //开始打游戏，记下时间戳
        System.out.println("开始时间是：2009-8-25 10:45");
        //获得类的class loader
        ClassLoader cl = player.getClass().getClassLoader();
        //动态产生一个代理者
        // 参数1 一个classloader对象，定义了由哪个classloader对象对生成的代理类进行加载
        // interfaces：一个interface对象数组，表示我们将要给我们的代理对象提供一组什么样的接口，如果我们提供了这样一个接口对象数组，那么也就是声明了代理类实现了这些接口，代理类就可以调用接口中声明的所有方法。
        // 一个InvocationHandler对象，表示的是当动态代理对象调用方法的时候会关联到哪一个InvocationHandler对象上，并最终由其调用。

        // 第二个参数也可以为：player.getClass().getInterfaces()
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);

        //登录
        proxy.login("zhangSan", "password");
        //开始杀怪
        proxy.killBoss();
        //升级
        proxy.upgrade();
        //记录结束游戏时间
        System.out.println("结束时间是：2009-8-26 03:40");


    }

}
