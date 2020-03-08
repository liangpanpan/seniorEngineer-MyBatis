package com.pp.dgexample.dynamicproxy;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public interface IGamePlayer {
    //登录游戏
    void login(String user, String password);

    //杀怪，网络游戏的主要特色
    void killBoss();

    //升级
    void upgrade();
}
