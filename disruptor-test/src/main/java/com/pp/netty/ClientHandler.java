package com.pp.netty;

import com.pp.netty.common.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            TranslatorData response = (TranslatorData) msg;
            log.info("Client端:id=" + response.getId()
                    + ", name=" + response.getName()
                    + ", message=" + response.getMessage());
        } finally {
            // 释放缓存
            ReferenceCountUtil.release(msg);
        }
    }
}



