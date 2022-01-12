package com.pp.netty.common;

import com.lmax.disruptor.RingBuffer;
import io.netty.channel.ChannelHandlerContext;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
public class MessageProducer {
    private String producerId;
    private RingBuffer<TranslatorDataWrapper> ringBuffer;

    public MessageProducer(String producerId,
                           RingBuffer<TranslatorDataWrapper> ringBuffer) {
        this.producerId = producerId;
        this.ringBuffer = ringBuffer;
    }

    public void sendData(TranslatorData data, ChannelHandlerContext ctx) {
        long sequence = ringBuffer.next();
        try {
            TranslatorDataWrapper wrapper = ringBuffer.get(sequence);
            wrapper.setTranslatorData(data);
            wrapper.setChannelHandlerContext(ctx);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

