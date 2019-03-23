package com.perye.imagesearch.error;

import org.json.JSONObject;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
public enum AipError {
    SUCCESS("0", "Success"),
    IMAGE_SIZE_ERROR("SDK100", "image size error"),
    IMAGE_LENGTH_ERROR("SDK101", "image length error"),
    IMAGE_READ_ERROR("SDK102", "read image file error"),
    USER_INFO_SIZE_ERROR("SDK103", "user_info size error"),
    GROUP_ID_FORMAT_ERROR("SDK104", "group_id format error"),
    GROUP_ID_SIZE_ERROR("SDK105", "group_id size error"),
    UID_FORMAT_ERROR("SDK106", "uid format error"),
    UID_SIZE_ERROR("SDK107", "uid size error"),
    NET_TIMEOUT_ERROR("SDK108", "connection or read data time out"),
    UNSUPPORTED_IMAGE_FORMAT_ERROR("SDK109", "unsupported image format"),
    ILLEGAL_REQUEST_ID_ERROR("SDK110", "illegal request id found: "),     // 填充具体id
    ASYNC_TIMEOUT_ERROR("SDK111", "wait for aysnc result timeout"),
    DOWNLOAD_FILE_ERROR("SDK112", "download file failed");

    private final String errorCode;
    private final String errorMsg;

    AipError(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMsg;
    }

    public JSONObject toJsonResult() {
        JSONObject json = new JSONObject();
        json.put("error_code", errorCode);
        json.put("error_msg", errorMsg);
        return json;
    }

    @Override
    public String toString() {
        return toJsonResult().toString();
    }
}