package com.pp.socket;

import com.alibaba.fastjson.JSON;
import com.pp.util.SocketConnection;

import java.util.HashMap;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/9       create this file
 * </pre>
 */
public class SocketRequest {

    public static void main(String[] args) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", "adminconf");

        SocketBo socketBo = new SocketBo()
                .setPath("/systemManager/updateIocRequest");

        SocketConnection socketConnectionUtils = new SocketConnection("localhost", 9000);
        String result = socketConnectionUtils.send(JSON.toJSONString(socketBo));
        System.out.println(result);


    }

}
