package com.gc.dgmodel.builder;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public abstract class Builder {

    //设置产品的不同部分，以获得不同的产品
    public abstract void setPart();

    //建造产品
    public abstract Product buildProduct();
}
