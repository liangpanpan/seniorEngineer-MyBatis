package com.pp.dgexample.state;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/18       create this file
 * </pre>
 */
public class ClosingState extends LiftState {
    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    //电梯门关了再打开
    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);  //置为敞门状态
        super.context.getLiftState().open();
    }

    //电梯门关了就运行，这是再正常不过了
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState); //设置为运行状态
        super.context.getLiftState().run();
    }

    //电梯门关着，我就不按楼层
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);  //设置为停止状态
        super.context.getLiftState().stop();
    }

}
