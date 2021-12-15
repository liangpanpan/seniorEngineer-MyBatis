package com.pp.reflect;

import java.lang.reflect.ParameterizedType;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/11/18       create this file
 * </pre>
 */
public class T1<T> {

    private Class classt;

    public T1() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.classt = (Class) type.getActualTypeArguments()[0];
        System.out.println(this.classt);
    }

}
