package com.perye.imagesearch.service;

import com.perye.imagesearch.imagesearch.AipImageSearch;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;

/**
 * 测试
 * @Author: Perye
 * @Date: 2019-03-23
 */
public class Sample {

    public static String APP_ID = "xxxxx";

    public static String API_KEY = "xxxxxxx";

    public static String SECRET_KEY = "xxxxxxxx";

    public static void main(String[] args) {
//        初始化一个AipImageSearch
        AipImageSearch aipImageSearch = new AipImageSearch(APP_ID, API_KEY, SECRET_KEY);


        HashMap<String, String> options = new HashMap<String, String>();
        options.put("brief", "{\"name\":\"perye\", \"id\":\"666\"}");
        options.put("tags", "666");

        String image = "/Users/perye/Desktop/1.jpg";
        JSONObject res = aipImageSearch.sameHqAdd(image, options);
        System.out.println(res.toString(2));

        // 参数为二进制数组
//        byte[] file = readFile("test.jpg");
//        res = aipImageSearch.sameHqAdd(file, options);
//        System.out.println(res.toString(2));

        // 相同图检索—入库, 图片参数为远程url图片
//        JSONObject res1 = aipImageSearch.sameHqAddUrl("https://graph.baidu.com/resource/106dfe835b7ff61c5107101553328679.jpg", options);
//        System.out.println(res1.toString(2));
    }

}
