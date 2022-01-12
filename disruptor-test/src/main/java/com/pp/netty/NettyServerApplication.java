package com.pp.netty;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import com.pp.netty.common.MessageConsumer;
import com.pp.netty.common.RingBufferWorkerPoolFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
@SpringBootApplication
public class NettyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class, args);
        MessageConsumer[] consumers = new MessageConsumer[10];
        for (int i = 0; i < consumers.length; ++i) {
            consumers[i] = new MessageConsumerImplForServer("code:serverId:" + i);
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(
                ProducerType.MULTI,
                1024 * 1024,
                new BlockingWaitStrategy(),
                consumers);
        new NettyServer();
    }

}

