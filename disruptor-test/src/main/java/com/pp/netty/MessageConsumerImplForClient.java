package com.pp.netty;

import com.pp.netty.common.MessageConsumer;
import com.pp.netty.common.TranslatorData;
import com.pp.netty.common.TranslatorDataWrapper;
import io.netty.util.ReferenceCountUtil;
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
public class MessageConsumerImplForClient extends MessageConsumer {
    public MessageConsumerImplForClient(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWrapper event) throws Exception {
        TranslatorData translatorData = event.getTranslatorData();
        try {
            log.info("Client端:id=" + translatorData.getId()
                    + ", name=" + translatorData.getName()
                    + ", message=" + translatorData.getMessage());
        } finally {
            // 释放缓存
            ReferenceCountUtil.release(translatorData);
        }
    }
}

