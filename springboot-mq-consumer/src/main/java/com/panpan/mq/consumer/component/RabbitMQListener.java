package com.panpan.mq.consumer.component;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/12/3       create this file
 * </pre>
 */
@Component
public class RabbitMQListener {

    /**
     * queues: 队列名称
     * concurrency 接收最小2个消息，最大4个消息
     *
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = "direct_queue", concurrency = "2-4")
    public void getRabbitMQMessage(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println(("MQ接收到的消息： " + new String(message.getBody())));
    }

}
