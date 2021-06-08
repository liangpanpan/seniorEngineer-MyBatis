package com.pp.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author       Date        Description
 * ============ =========== ============================
 *              2019-06-24  creat this file
 * </pre>
 */

public final class HttpClientUtil {

    private HttpClientUtil() {

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static String doPost(String url, Map<String, Object> map,
                                String charset) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = createSSLClientDefault();
            httpPost = new HttpPost(url);
            // 设置参数
            List<NameValuePair> list = new ArrayList<>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> elem =
                        (Map.Entry<String, Object>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),
                        String.valueOf(elem.getValue())));
            }
            if (!list.isEmpty()) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,
                        charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
        } finally {
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                }
            }
        }
        return result;
    }


    /**
     * 创建SSLClientDefault
     *
     * @return 返回SSLClientDefault，信任所有的证书
     */
    private static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext =
                    new SSLContextBuilder().loadTrustMaterial(null,
                            new TrustStrategy() {
                                // 信任所有
                                public boolean isTrusted(X509Certificate[] chain,
                                                         String authType) {
                                    return true;
                                }
                            }).build();
            SSLConnectionSocketFactory sslsf =
                    new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategyCustom()).setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

}



