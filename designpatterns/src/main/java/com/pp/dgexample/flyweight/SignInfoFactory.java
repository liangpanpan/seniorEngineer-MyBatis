package com.pp.dgexample.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/20       create this file
 * </pre>
 */
public class SignInfoFactory {

    // 池容量
    private static Map<String, SignInfo> pool = new HashMap<>();

    //报名信息的对象工厂
    @Deprecated
    //报名信息的对象工厂
    public static SignInfo getSignInfo() {
        return new SignInfo();
    }

    //从池中获得对象
    public static SignInfo getSignInfo(String key) {
        //设置返回对象
        SignInfo result;
        //池中没有该对象，则建立，并放入池中
        if (!pool.containsKey(key)) {
            System.out.println(key + "----建立对象，并放置到池中");
            result = new SignInfo4Pool(key);
            pool.put(key, result);
        } else {
            result = pool.get(key);
            System.out.println(key + "---直接从池中取得");
        }
        return result;
    }


}
