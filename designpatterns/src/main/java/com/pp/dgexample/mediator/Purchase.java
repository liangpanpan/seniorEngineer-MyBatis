package com.pp.dgexample.mediator;

/**
 * @Title 采购者
 * @Description
 * @Author ppliang
 * @Date 2020/3/30
 */
public class Purchase extends AbstractColleague {
    public Purchase(AbstractMediator _mediator) {
        super(_mediator);
    }

    //采购IBM电脑
    public void buyIBMcomputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    //不再采购IBM电脑
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }
}
