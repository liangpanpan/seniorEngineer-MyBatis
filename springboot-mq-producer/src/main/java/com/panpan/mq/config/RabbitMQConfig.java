package com.panpan.mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.nio.charset.Charset;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/12/2       create this file
 * </pre>
 */
@Configuration
public class RabbitMQConfig {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public static final String BINDING_KEY = "binding_key";

    public static final String ITEM_DIRECT_EXCHANGE = "direct_exchange";

    public static final String DIRECT_QUEUE = "direct_queue";

    @Bean("bootExchange")
    public Exchange bootExchange() {

        /**
         * 创建交换机
         * ExchangeBuilder.fanoutExchange() 创建广播交换机
         * ExchangeBuilder.directExchange() 创建直接交换机
         * ExchangeBuilder.topicExchange()  创建路由交换机
         *
         * durable()  true 持久化 MQ重启后交换机还在
         * autoDelete()
         *
         */
        return ExchangeBuilder.directExchange(ITEM_DIRECT_EXCHANGE).durable(true).build();
    }

    /**
     * //boolean isDurable = true;// 是否持久化
     * <p>
     * //boolean isExclusive = false; // 仅创建者可以使用的私有队列, 断开后自动删除
     * <p>
     * //boolean isAutoDelete = false; // 当所有消费客户端连接断开后, 是否自动删除队列
     *
     * @return
     */
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(DIRECT_QUEUE).build();
    }

    @Bean
    public Binding bindingQueue(@Qualifier("bootExchange") Exchange exchange, @Qualifier("bootQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(BINDING_KEY).noargs();
    }


    /**
     * 消息从 producer 到 exchange 则会返回一个 confirmCallback 。
     * 消息从 exchange-->queue 投递失败则会返回一个 returnCallback 。
     *
     * @return
     */
    @Bean
    public AmqpTemplate amqpTemplate() {
        Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);
//          使用jackson 消息转换器
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
//        开启returncallback     yml 需要 配置    publisher-returns: true
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            // String correlationId = message.getMessageProperties().getCorrelationIdString();

            String messageBody = "";
            byte[] messageByte = message.getBody();
            if (messageByte != null) {
                messageBody = new String(messageByte, Charset.defaultCharset());
            }

            log.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", messageBody, replyCode, replyText, exchange,
                    routingKey);
        });


        //        消息确认  yml 需要配置   publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息发送到exchange成功,id: {}", correlationData.getId());
            } else {
                log.info("消息发送到exchange失败,原因: {}", cause);
            }
        });
        return rabbitTemplate;
    }

}
