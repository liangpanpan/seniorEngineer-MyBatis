package com.pp.netty.common;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/1/10       create this file
 * </pre>
 */
@Data
public class TranslatorDataWrapper {

    private TranslatorData translatorData;

    private ChannelHandlerContext channelHandlerContext;
}

