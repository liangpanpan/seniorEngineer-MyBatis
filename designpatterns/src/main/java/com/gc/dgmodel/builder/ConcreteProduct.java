package com.gc.dgmodel.builder;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class ConcreteProduct extends Builder {
    private Product product = new Product();

    //设置产品零件
    public void setPart() {
        /*
         * 产品类内的逻辑处理
         */
        System.out.println(" ConcreteProduct setPart");
    }

    //组建一个产品
    public Product buildProduct() {
        return product;
    }
}
