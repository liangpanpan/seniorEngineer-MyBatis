package com.pp.pcap;

import org.jnetpcap.Pcap;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.packet.structure.JField;
import org.jnetpcap.protocol.lan.Ethernet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/3/23       create this file
 * </pre>
 */
public class PcapViewer {

    private static final Logger logger = LoggerFactory.getLogger(PcapViewer.class);
    private static Ethernet header;

    public static void main(String[] args) {
        final StringBuilder error = new StringBuilder();

        // 打开pcap文件
        Pcap pcap = Pcap.openOffline("D:\\test_tcp.pcap", error);
        if (pcap == null) {
            System.err.println(error);
            return;
        }

        // 创建PcapPacketHandler以处理每个数据包
        PcapPacketHandler<StringBuilder> handler = (packet, sb) -> {
            // 解析数据包并将其添加到字符串构建器中
            sb.append(" ")
                    .append(packet.getCaptureHeader().caplen())
                    .append(" ")
                    .append(packet.getCaptureHeader().wirelen())
//                        .append("\n")
//                        .append(packet.toHexdump())
                    .append("\n")
                    .append(packet);


            Ethernet header = packet.getHeader(new Ethernet());
            logger.info("id:{} {}", header.typeEnum().getId(), header.typeEnum().getDescription());

            for (JField jField : header.getFields()) {
                logger.info(jField.toString());
            }
        };

        // 循环读取数据包并使用PcapPacketHandler处理它们
        StringBuilder sb = new StringBuilder();
        pcap.loop(-1, handler, sb);

        // 输出结果
        System.out.println(sb);

        // 关闭pcap文件
        pcap.close();
    }
}
