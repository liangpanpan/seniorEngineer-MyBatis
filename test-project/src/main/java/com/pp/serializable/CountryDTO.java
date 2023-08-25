package com.pp.serializable;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

/**
 * 该测试类是为了验证JsonObject 进行序列号的时候，如下四种情况不进行序列号
 * case1: @JSONField(serialize = false)
 * case2: getXxx()返回值为void
 * case3: isXxx()返回值不等于布尔类型
 * case4: @JSONType(ignores = "xxx")
 */
@JSONType(ignores = "otherName")
public class CountryDTO implements Serializable {
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public static void queryCountryList() {
        System.out.println("queryCountryList()执行!!");
    }

    public Boolean isChinaName() {
        System.out.println("isChinaName()执行!!");
        return true;
    }

    public String getEnglishName() {
        System.out.println("getEnglishName()执行!!");
        return "lucy";
    }

    public String getOtherName() {
        System.out.println("getOtherName()执行!!");
        return "lucy";
    }

    /**
     * case1: @JSONField(serialize = false)
     */
    @JSONField(serialize = false)
    public String getEnglishName2() {
        System.out.println("getEnglishName2()执行!!");
        return "lucy";
    }

    /**
     * case2: getXxx()返回值为void
     */
    public void getEnglishName3() {
        System.out.println("getEnglishName3()执行!!");
    }

    /**
     * case3: isXxx()返回值不等于布尔类型
     */
    public String isChinaName2() {
        System.out.println("isChinaName2()执行!!");
        return "isChinaName2";
    }


    public static void main(String[] args) {
        CountryDTO countryDTO = new CountryDTO();
        String str = JSON.toJSONString(countryDTO);
        System.out.println(str);
    }


}

