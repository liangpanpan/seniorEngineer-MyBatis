package com.pp.netty;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
// @SpringBootApplication
public class NettyClientApplication {

    public static void main(String[] args) {
        // SpringApplication.run(NettyClientApplication.class, args);
        // MessageConsumer[] consumers = new MessageConsumer[4];
        // for (int i = 0; i < consumers.length; ++i) {
        //     consumers[i] = new MessageConsumerImplForClient("code:clientId:" + i);
        // }
        // RingBufferWorkerPoolFactory.getInstance().initAndStart(
        //         ProducerType.MULTI,
        //         1024 * 1024,
        //         new BlockingWaitStrategy(),
        //         consumers);
        // 建立连接并发送消息
        new NettyClient().sendData();
    }

}


