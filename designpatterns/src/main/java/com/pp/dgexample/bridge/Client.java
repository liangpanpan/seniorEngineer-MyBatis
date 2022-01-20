package com.pp.dgexample.bridge;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class Client {

    public static void main(String[] args) {
        House house = new House();
        System.out.println("-------房地产公司是这样运行的-------");
        //先找到房地产公司
        HouseCorp houseCorp = new HouseCorp(house);
        //看我怎么挣钱
        houseCorp.makeMoney();


        //山寨公司生产的产品很多，不过我只要指定产品就成了
        System.out.println("-------山寨公司是这样运行的-------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();

        System.out.println("-------山寨公司是这样运行的-------");
        shanZhaiCorp = new ShanZhaiCorp(new Clothes());
        shanZhaiCorp.makeMoney();

    }

}
