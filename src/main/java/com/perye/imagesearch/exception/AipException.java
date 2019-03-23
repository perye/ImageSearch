package com.perye.imagesearch.exception;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
public class AipException extends Exception {

    private String errorMsg;
    private int errorCode;

    public AipException(int code, String msg) {
        errorCode = code;
        errorMsg = msg;
    }

    public AipException(int code, Throwable e) {
        errorCode = code;
        errorMsg = e.getMessage();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
