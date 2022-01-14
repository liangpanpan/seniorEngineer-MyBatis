package com.pp.dgexample.chain;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/14       create this file
 * </pre>
 */
public class Husband extends Handler {
    //父亲只处理女儿的请求
    public Husband() {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    //父亲的答复
    @Override
    protected void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }

}
