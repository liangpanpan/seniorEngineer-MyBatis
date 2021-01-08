package com.pp.spi;

import java.util.ServiceLoader;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/8       create this file
 * </pre>
 */
public class SPIDemo {

    public static void main(String[] args) {
        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        load.forEach(animal -> {
            animal.say();
        });
    }

}
