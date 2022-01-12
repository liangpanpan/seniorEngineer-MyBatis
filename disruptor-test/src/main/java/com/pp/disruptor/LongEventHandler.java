package com.pp.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * 消费者，事件监听
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        //消费，数据处理
        System.out.println(event.getValue());
    }

}

