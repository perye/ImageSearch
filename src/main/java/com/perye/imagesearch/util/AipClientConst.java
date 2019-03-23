package com.perye.imagesearch.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
public class AipClientConst {

    // for cloudAuth
    public static final Integer BCE_AUTH_EXPIRE_IN_SECONDS = 1800;  // 30min
    public static final HashSet<String> BCE_HEADER_TO_SIGN =
            new HashSet<String>(Arrays.asList("host", "content-md5", "content-length", "content-type"));
    public static final String BCE_PREFIX = "x-bce-";

    // for openapi
    public static final String OAUTH_URL = "https://aip.baidubce.com/oauth/2.0/token";

    // encoding
    public static final String DEFAULT_ENCODING = "UTF8";
    public static final String ENCODING_GBK = "GBK";

    // openAPI access right
    public static final List<String> AI_ACCESS_RIGHT =
            Arrays.asList(
                    "audio_voice_assistant_get",            // speech
                    "audio_tts_post",
                    "brain_all_scope");


    public static final Integer IAM_ERROR_CODE = 14;
    public static final Integer OPENAPI_NO_ACCESS_ERROR_CODE = 6;
    public static final String OPENAPI_NO_ACCESS_ERROR_MSG = "No permission to access data";

    public static final String LOG4J_CONF_PROPERTY = "aip.log4j.conf";
}
