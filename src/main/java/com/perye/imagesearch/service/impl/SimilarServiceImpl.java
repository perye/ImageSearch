package com.perye.imagesearch.service.impl;

import com.perye.imagesearch.config.APPConfig;
import com.perye.imagesearch.imagesearch.AipImageSearch;
import com.perye.imagesearch.service.SimilarService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
@Service
public class SimilarServiceImpl implements SimilarService {
    AipImageSearch aipImageSearch = new AipImageSearch(APPConfig.APP_ID, APPConfig.API_KEY, APPConfig.SECRET_KEY);
    @Override
    public JSONObject similarAdd(byte[] image, HashMap<String, String> options) {
        return aipImageSearch.similarAdd(image, options);
    }

    @Override
    public JSONObject similarDel(byte[] image, HashMap<String, String> options) {
        return aipImageSearch.similarDeleteByImage(image,options);
    }

    @Override
    public JSONObject similarUpdate(byte[] image, HashMap<String, String> options) {
        return aipImageSearch.similarUpdate(image,options);
    }

    @Override
    public JSONObject similarSearch(byte[] image, HashMap<String, String> options) {
        return aipImageSearch.similarSearch(image,options);
    }
}
