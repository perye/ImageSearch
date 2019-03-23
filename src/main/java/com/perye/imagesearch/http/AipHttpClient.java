package com.perye.imagesearch.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
public class AipHttpClient {


    /**
     * post方式请求服务器(https协议)
     *
     * @param request 请求内容
     * @return AipResponse
     */
    public static AipResponse post(AipRequest request) {
        String url;
        String charset = request.getContentEncoding();
        String content = request.getBodyStr();
        HashMap<String, String> header = request.getHeaders();
        AipResponse response = new AipResponse();

        DataOutputStream out = null;
        InputStream is = null;
        try {
            if (request.getParams().isEmpty()) {
                url = request.getUri().toString();
            }
            else {
                url = String.format("%s?%s", request.getUri().toString(), request.getParamStr());
            }

            URL console = new URL(url);
            Proxy proxy = request.getConfig() == null ? Proxy.NO_PROXY : request.getConfig().getProxy();
            HttpURLConnection conn = (HttpURLConnection) console.openConnection(proxy);

            // set timeout
            if (request.getConfig() != null) {
                conn.setConnectTimeout(request.getConfig().getConnectionTimeoutMillis());
                conn.setReadTimeout(request.getConfig().getSocketTimeoutMillis());
            }
            conn.setDoOutput(true);
            // 添加header
            for (Map.Entry<String, String> entry : header.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }

            conn.connect();
            out = new DataOutputStream(conn.getOutputStream());
            out.write(content.getBytes(charset));
            out.flush();
            int statusCode = conn.getResponseCode();
            response.setHeader(conn.getHeaderFields());
            response.setStatus(statusCode);
            response.setCharset(charset);
            if (statusCode != 200) {
                return response;
            }

            is = conn.getInputStream();
            if (is != null) {
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                response.setBody(outStream.toByteArray());
            }
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

}
