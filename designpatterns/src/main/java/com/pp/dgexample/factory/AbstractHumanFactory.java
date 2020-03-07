package com.pp.dgexample.factory;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
