package com.panpan.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/12/9       create this file
 * </pre>
 */
@Configuration
public class RabbitDelayMQConfig {

    /**
     * TTL交换机名称
     */
    public static final String DELAY_DIRECT_EXCHANGE = "delay.direct.exchange";

    /**
     * TTL 队列
     */
    public static final String DELAY_DIRECT_QUEUE = "delay.direct.queue";

    /**
     * TTL交换机和队列绑定Key
     */
    public static final String DELAY_BINDING_KEY = "delay.binding.key";

    /**
     * 死信队列Key
     */
    public static final String DLX_ROUTING_KEY = "dlx.routing.key";

    /**
     * 延迟后正常接收消息的队列
     */
    public static final String NORMAL_QUEUE_NAME = "normal.queue.name";

    /**
     * 死信后接收消息的交换机
     */
    public static final String NORMAL_EXCHANGE_NAME = "normal.exchange.name";

    // 注入延迟消息的时间
    @Value("${server.delayTime}")
    private Integer delayTime;

    /**
     * 配置延迟队列，需要死信队列+TTL
     * 先配置TTL
     */
    @Bean("delayDirectExchange")
    public Exchange delayDirectExchange() {
        return ExchangeBuilder.directExchange(DELAY_DIRECT_EXCHANGE).durable(true).build();
    }

    @Bean("delayDirectQueue")
    public Queue delayDirectQueue() {

        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", NORMAL_EXCHANGE_NAME);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", DLX_ROUTING_KEY);
        // return new Queue(DELAY_DIRECT_QUEUE, true, false, false, params);

        /**
         * 延迟时间
         */
        params.put("x-message-ttl", delayTime);

        return QueueBuilder.durable(DELAY_DIRECT_QUEUE).withArguments(params).build();
    }

    /**
     * 对TTL交换机和队列进行绑定
     */
    @Bean
    public Binding delayBindingQueue() {
        return BindingBuilder.bind(delayDirectQueue()).to(delayDirectExchange())
                .with(DELAY_BINDING_KEY).noargs();
    }

    /**
     * 正常消费的队列
     *
     * @return
     */
    @Bean("normalDirectQueue")
    public Queue normalDirectQueue() {
        return QueueBuilder.durable(NORMAL_QUEUE_NAME).build();
    }

    @Bean("normalDirectExchange")
    public Exchange normalDirectExchange() {
        return ExchangeBuilder.directExchange(NORMAL_EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Binding normalBindingQueue(@Qualifier("normalDirectExchange") Exchange exchange,
                                      @Qualifier("normalDirectQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(DLX_ROUTING_KEY).noargs();
    }
}
