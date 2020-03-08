package com.pp.dgexample.builder;

import java.util.ArrayList;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/7
 */
public class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();

    public CarModel getCarModel() {
        return this.bmw;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}
