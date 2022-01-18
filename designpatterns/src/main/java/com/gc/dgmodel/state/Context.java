package com.gc.dgmodel.state;

/**
 * 具体环境角色有两个职责：处理本状态必须完成的任务，决定是否可以过渡到其他状态。
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class Context {
    //定义状态
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();

    //当前状态
    private State CurrentState;

    //获得当前状态
    public State getCurrentState() {
        return CurrentState;
    }

    //设置当前状态
    public void setCurrentState(State currentState) {
        this.CurrentState = currentState;
        //切换状态
        this.CurrentState.setContext(this);
    }

    //行为委托
    public void handle1() {
        this.CurrentState.handle1();
    }

    public void handle2() {
        this.CurrentState.handle2();
    }

}
