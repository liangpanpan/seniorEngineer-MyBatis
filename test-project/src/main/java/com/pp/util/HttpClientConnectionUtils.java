package com.pp.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/19       create this file
 * </pre>
 */
public class HttpClientConnectionUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientConnectionUtils.class);

    private static int connectTimeOut = 15000; // 默认的连接超时时间 15秒

    private static int soTimeOut = 15000; // 默认的连接超时时间 15秒

    public static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";

    public static final String CONTENT_TYPE_TEXT_XML = "text/xml";

    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";

    public static final String CONTENT_TYPE_TEXT_HTTP = "application/xml; charset=utf-8";

    public static final String CONTENT_TYPE_TEXT_JSON = "application/json";

    /**
     * 发送请求
     *
     * @param url      请求地址
     * @param valueMap POST请求的Key Value
     * @param charset  编码
     * @return 请求结果
     */
    public static String getResponse(String url, Map<String, String> valueMap, String charset) {
        String response = null;
        HttpPost httpPost = null;
        try {
            HttpClient httpClient = getHttpClient(url);

            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(soTimeOut).setConnectTimeout(connectTimeOut)
                            .setConnectionRequestTimeout(connectTimeOut).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_0);

            // 设置参数
            List<NameValuePair> list = new ArrayList<>();
            valueMap.entrySet().forEach(entry -> {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            });

            if (!list.isEmpty()) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }

            response = getHttpClientResponse(httpPost, httpClient);

        } catch (Exception e) {
            logger.error("", e);
        } finally {
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
        }
        return response;
    }

    /**
     * 进行POST提交，内容是字符串
     *
     * @param url         请求的地址
     * @param request     请求内容
     * @param charset     编码
     * @param contentType 请求类型
     * @return 响应结果
     */
    public static String getResponse(String url, String request, String charset, String contentType) {
        return getResponse(url, request, charset, contentType, connectTimeOut, soTimeOut);
    }

    /**
     * 带超时时间的请求
     *
     * @param url            请求地址
     * @param request        请求内容
     * @param charset        请求编码格式
     * @param contentType    请求类型
     * @param connectTimeOut 连接超时时间
     * @param soTimeOut      请求超时时间
     * @return 响应结果
     */
    public static String getResponse(String url, String request, String charset, String contentType,
                                     int connectTimeOut, int soTimeOut) {
        String response = null;
        HttpPost httpPost = null;
        try {
            HttpClient httpClient = getHttpClient(url);

            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(soTimeOut).setConnectTimeout(connectTimeOut)
                            .setConnectionRequestTimeout(connectTimeOut).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);

            httpPost.addHeader("Content-Type", contentType);

            httpPost.setEntity(new StringEntity(request, charset));

            response = getHttpClientResponse(httpPost, httpClient);
        } catch (Exception e) {
            logger.error("请求" + url + "异常", e);
        } finally {
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
        }
        return response;
    }

    private static HttpClient getHttpClient(String url) throws Exception {
        HttpClient httpClient;
        String lowerURL = url.toLowerCase();
        if (lowerURL.startsWith("https")) {
            httpClient = createSSLClientDefault();
        } else {
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }

    private static String getHttpClientResponse(HttpPost httpPost, HttpClient httpClient) throws Exception {
        String response = "";
        HttpResponse httpResponse = httpClient.execute(httpPost);
        logger.info("statusCode:" + httpResponse.getStatusLine().getStatusCode() + " ,message:" + httpResponse.getStatusLine().toString());
        HttpEntity entity = httpResponse.getEntity();

        if (null != entity) {
            try (InputStream inputStream = entity.getContent()) {
                response = IOUtils.toString(inputStream, "UTF-8");
            }
        }
        logger.info("response:" + response);
        return response;
    }

    private static CloseableHttpClient createSSLClientDefault() throws Exception {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
        return HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext)).build();
    }

    public static void setConnectTimeOut(int connectTimeOut) {
        HttpClientConnectionUtils.connectTimeOut = connectTimeOut;
    }

    public static void setSoTimeOut(int soTimeOut) {
        HttpClientConnectionUtils.soTimeOut = soTimeOut;
    }


}
