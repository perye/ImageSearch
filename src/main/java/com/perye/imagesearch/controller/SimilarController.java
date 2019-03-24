package com.perye.imagesearch.controller;

import com.perye.imagesearch.service.SimilarService;
import com.perye.imagesearch.util.FileUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 相似图
 *
 * @Author: Perye
 * @Date: 2019-03-23
 */
@RestController
@CrossOrigin
public class SimilarController {

    @Autowired
    private SimilarService similarService;

    @PostMapping("/add")
    public String similarAdd(MultipartFile file, HashMap<String, String> options) {
        try {
            byte[] image = file.getBytes();
            String imageName = file.getOriginalFilename();
            options.put("brief", imageName);
            InputStream inputStream = file.getInputStream();
            FileUtil.savePic(inputStream, imageName);
            return String.valueOf(similarService.similarAdd(image, options));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/search")
    public String similarSearch(MultipartFile file, HashMap<String, String> options) {
        try {
            byte[] image = file.getBytes();
            JSONObject jsonObject = similarService.similarSearch(image, options);
            JSONArray result = jsonObject.getJSONArray("result");
            return String.valueOf(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
