package com.pp.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 使用Socket或SSLSOcket与服务器通讯
 * <pre>
 * Modify Information:
 * Author       Date        Description
 * ============ =========== ============================
 * liangpanpan   2021-08-06
 * </pre>
 */
public class SocketConnection {

    private static final Logger logger = LoggerFactory.getLogger(SocketConnection.class);

    private String host;

    private int port;

    private boolean ssl = false;

    private int bufferSize = 1024;

    // 默认10秒钟
    private int connectTimeout = 10000;
    // 默认10秒钟
    private int soTimeout = 10000;

    public SocketConnection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String send(String request) {
        String response = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        Socket socket = null;
        try {
            socket = new Socket();
            InetAddress inetAddress = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, port);
            socket.connect(inetSocketAddress, connectTimeout);
            socket.setSoTimeout(soTimeout);

            // Output
            outputStream = socket.getOutputStream();
            outputStream.write(request.getBytes("UTF-8"));
            outputStream.flush();

            socket.shutdownOutput();

            // Input
            inputStream = socket.getInputStream();
            response = IOUtils.toString(inputStream, "UTF-8");
        } catch (Exception e) {
            logger.error("请求Socket异常", e);
        } finally {
            try {

                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }

                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                logger.error("Close stream or connection failed", e);
            }
        }
        return response;
    }


    public boolean isSSL() {
        return ssl;
    }

    public void setSSL(boolean ssl) {
        this.ssl = ssl;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

}
