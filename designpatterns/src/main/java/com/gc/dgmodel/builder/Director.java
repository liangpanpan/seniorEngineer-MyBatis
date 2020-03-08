package com.gc.dgmodel.builder;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class Director {
    private Builder builder = new ConcreteProduct();

    //构建不同的产品
    public Product getAProduct() {

        builder.setPart();
        /*
         * 设置不同的零件，产生不同的产品
         */
        return builder.buildProduct();
    }
}
