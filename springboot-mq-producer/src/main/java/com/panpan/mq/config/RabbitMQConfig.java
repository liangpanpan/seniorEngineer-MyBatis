package com.panpan.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    public static final String BINDING_KEY = "binding_key";

    public static final String ITEM_DIRECT_EXCHANGE = "direct_exchange";

    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.directExchange(ITEM_DIRECT_EXCHANGE).durable(true).build();
    }

    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable("direct_queue").exclusive().build();
    }

    @Bean
    public Binding bindingQueue(@Qualifier("bootExchange") Exchange exchange, @Qualifier("bootQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(BINDING_KEY).noargs();
    }

}
