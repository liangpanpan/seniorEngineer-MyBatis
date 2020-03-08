package com.pp.dgexample.builder;

import java.util.ArrayList;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();

    public CarModel getCarModel() {
        return this.benz;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }
}
