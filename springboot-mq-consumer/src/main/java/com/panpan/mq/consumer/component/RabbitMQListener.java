package com.panpan.mq.consumer.component;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
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
@Slf4j
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
    @RabbitListener(queues = "direct_queue")
    // @RabbitListener(queues = "direct_queue", concurrency = "10")
    // @RabbitListener(queues = "direct_queue", concurrency = "5",
    // containerFactory = "mqlistenerContainer")
    public void getRabbitMQMessage(Message message, Channel channel,
                                   @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, InterruptedException {

        String messageStr = new String(message.getBody(), "UTF-8");

        log.info("receive message:" + messageStr + " tag:" + tag);

        if ("1".equals(messageStr)) {
            // 当消息为1时不进行消费
            channel.basicNack(message.getMessageProperties().getDeliveryTag()
                    , false, true);
        } else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),
                    false);
        }

        Thread.sleep(10000);
    }


    /**
     * 接收延迟消息队列内的消息
     *
     * @param message
     * @param channel
     * @param tag
     * @throws IOException
     */
    @RabbitListener(queues = "normal.queue.name", concurrency = "2")
    public void getRabbitDelayMQMessage(Message message, Channel channel,
                                        @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        String messageStr = new String(message.getBody(), "UTF-8");

        log.info("receive delay message:" + messageStr + " tag:" + tag);

        if ("1".equals(messageStr)) {
            // 当消息为1时不进行消费
            channel.basicNack(message.getMessageProperties().getDeliveryTag()
                    , false, true);
        } else {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),
                    false);
        }
    }

}
