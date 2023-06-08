package com.pp.dgexample.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class GamePlayIH implements InvocationHandler {
    //被代理者
    Class cls = null;
    //被代理的实例
    Object obj = null;

    //我要代理谁
    public GamePlayIH(Object _obj) {
        this.obj = _obj;
    }

    //调用被代理的方法

    /**
     * @param proxy  代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * @param method 我们所要调用某个对象真实的方法的Method对象
     * @param args   指代代理对象方法传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.obj, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

}
