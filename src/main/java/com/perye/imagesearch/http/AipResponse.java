package com.perye.imagesearch.http;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
public class AipResponse {

    private Map<String, List<String>> header;
    private byte[] body;
    private String charset;
    private int status;

    public AipResponse() {
        status = 0;
        charset = "UTF-8";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBodyStr() {
        if (body == null) {
            return "";
        }
        try {
            return new String(body, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(body);
        }
    }

    public Map<String, List<String>> getHeader() {
        return header;
    }

    public void setHeader(Map<String, List<String>> header) {
        this.header = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, List<String>> entry: header.entrySet()) {
            if (entry.getKey() != null) {
                this.header.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}