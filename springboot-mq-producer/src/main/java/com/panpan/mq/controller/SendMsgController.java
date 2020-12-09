package com.panpan.mq.controller;

import com.panpan.mq.config.RabbitDelayMQConfig;
import com.panpan.mq.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/12/2       create this file
 * </pre>
 */
@RestController
public class SendMsgController {

    //注入RabbitMQ的模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;


    /**
     * 测试
     */
    @GetMapping("/sendmsg")
    public String sendMsg(@RequestParam String msg, @RequestParam String key) {
        /**
         * 发送消息
         * 参数一：交换机名称
         * 参数二：路由key: item.springboot-rabbitmq,符合路由item.#规则即可
         * 参数三：发送的消息
         */
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_DIRECT_EXCHANGE, RabbitMQConfig.BINDING_KEY,
                msg + "key:" + key, correlationData);
        //返回消息
        return "发送消息成功！";
    }


    @GetMapping("/sendBatchMsg")
    public String sendBatchMsg(@RequestParam String msg, @RequestParam Integer batchNum) {
        /**
         * 发送消息
         * 参数一：交换机名称
         * 参数二：路由key: item.springboot-rabbitmq,符合路由item.#规则即可
         * 参数三：发送的消息
         */

        for (int i = 0; i < batchNum; i++) {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_DIRECT_EXCHANGE, RabbitMQConfig.BINDING_KEY,
                    msg + " num:" + i, correlationData);
        }
        //返回消息
        return "发送消息成功！";
    }


    /**
     * 测试
     */
    @GetMapping("/sendDelayMsg")
    public String sendDelayMsg(@RequestParam String msg) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitDelayMQConfig.DELAY_DIRECT_EXCHANGE, RabbitDelayMQConfig.DELAY_BINDING_KEY,
                msg, correlationData);
        return "发送消息" + msg + "成功！";
    }

    /**
     * 路由Key失败
     *
     * @param msg
     * @param key
     * @return
     */
    @GetMapping("/sendReturnmsg")
    public String sendReturnMsg(@RequestParam String msg, @RequestParam String key) {

        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_DIRECT_EXCHANGE, key,
                msg);
        //返回消息
        return "发送消息到MQ上，队列错误！";
    }


    @GetMapping("/sendConfirmMsg")
    public String sendConfirmMsg(@RequestParam String msg, @RequestParam String key) {
        /**
         * 交换机错误
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_DIRECT_EXCHANGE + "1", key,
                msg);
        //返回消息
        return "发送消息到MQ上，交换机错误！";
    }

}