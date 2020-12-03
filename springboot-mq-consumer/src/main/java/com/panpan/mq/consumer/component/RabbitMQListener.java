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

    @RabbitListener(queues = "direct_queue")
    public void getRabbitMQMessage(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        System.out.println(("MQ接收到的消息： " + new String(message.getBody())));
    }

}
