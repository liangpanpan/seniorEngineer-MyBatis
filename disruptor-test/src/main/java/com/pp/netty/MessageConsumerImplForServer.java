package com.pp.netty;

import com.pp.netty.common.MessageConsumer;
import com.pp.netty.common.TranslatorData;
import com.pp.netty.common.TranslatorDataWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
@Slf4j
public class MessageConsumerImplForServer extends MessageConsumer {

    public MessageConsumerImplForServer(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWrapper event) throws Exception {
        TranslatorData translatorData = event.getTranslatorData();
        log.info("Server端:id=" + translatorData.getId() + ", name=" + translatorData.getName() + ", message=" + translatorData.getMessage());
        TranslatorData response = new TranslatorData();
        response.setId("resp:" + translatorData.getId());
        response.setName("resp:" + translatorData.getName());
        response.setMessage("resp:" + translatorData.getMessage());
        event.getChannelHandlerContext().writeAndFlush(response);
    }
}

