package com.pp.dgexample.mediator;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/30
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator _mediator) {
        this.mediator = _mediator;
    }
}
