package com.perye.imagesearch.service;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * 相似图查找
 * @Author: Perye
 * @Date: 2019-03-23
 */
public interface SimilarService {

    /**
     * 相似图检索-入库
     * @param image
     * @param options
     * @return
     */
    public JSONObject similarAdd(byte[] image, HashMap<String,String> options);

    /**
     * 相似图检索-删除
     * @param image
     * @param options
     * @return
     */
    public JSONObject similarDel(byte[] image, HashMap<String,String> options);

    /**
     * 相似图检索-修改
     * @param image
     * @param options
     * @return
     */
    public JSONObject similarUpdate(byte[] image, HashMap<String,String> options);

    /**
     * 相似图检索-检索
     * @param image
     * @param options
     * @return
     */
    public JSONObject similarSearch(byte[] image, HashMap<String,String> options);


}
