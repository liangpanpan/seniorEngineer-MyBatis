package com.gc.dgmodel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class MyInvocationHandler implements InvocationHandler {
    //被代理的对象
    private Object target = null;

    //通过构造函数传递一个对象
    public MyInvocationHandler(Object _obj) {
        this.target = _obj;
    }

    //代理方法
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //执行被代理的方法
        return method.invoke(this.target, args);
    }
}
