package com.pp.netty.common;

import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
public class RingBufferWorkerPoolFactory {
    private static class SingletonHolder {
        static final RingBufferWorkerPoolFactory INSTANCE = new RingBufferWorkerPoolFactory();
    }

    private RingBufferWorkerPoolFactory() {

    }

    public static RingBufferWorkerPoolFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static Map<String, MessageProducer> producers = new ConcurrentHashMap<>();

    // private static Map<String, MessageConsumer> consumers = new ConcurrentHashMap<>();

    private RingBuffer<TranslatorDataWrapper> ringBuffer;

    private SequenceBarrier sequenceBarrier;

    private WorkerPool<TranslatorDataWrapper> workerPool;

    public void initAndStart(ProducerType producerType,
                             int bufferSize,
                             WaitStrategy waitStrategy,
                             MessageConsumer[] messageConsumers) {
        // 1.构建ringBuffer对象
        this.ringBuffer = RingBuffer.create(producerType,
                () -> new TranslatorDataWrapper(),
                bufferSize,
                waitStrategy);
        // 2.设置序号栅栏
        this.sequenceBarrier = ringBuffer.newBarrier();
        // 3.设置工作池
        this.workerPool = new WorkerPool<>(
                this.ringBuffer,
                this.sequenceBarrier,
                new EventExceptionHandler(),
                messageConsumers);
        // 4.把所构建的消费者置入池中
        // for (MessageConsumer consumer : messageConsumers) {
        //     consumers.put(consumer.getConsumerId(), consumer);
        // }
        // 5.添加sequences
        this.ringBuffer.addGatingSequences(this.workerPool.getWorkerSequences());

        // 6.启动工作池
        this.workerPool.start(
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2)
        );
    }

    public MessageProducer getMessageProducer(String producerId) {
        MessageProducer messageProducer = producers.get(producerId);
        if (null == messageProducer) {
            messageProducer = new MessageProducer(producerId, this.ringBuffer);
            producers.put(producerId, messageProducer);
        }
        return messageProducer;
    }

    static class EventExceptionHandler implements ExceptionHandler<TranslatorDataWrapper> {

        @Override
        public void handleEventException(Throwable ex, long sequence, TranslatorDataWrapper event) {

        }

        @Override
        public void handleOnStartException(Throwable ex) {

        }

        @Override
        public void handleOnShutdownException(Throwable ex) {

        }
    }
}

