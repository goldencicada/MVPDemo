package com.cicada.mvpdemo.base;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Cicada
 * @date 2018/6/25 0025
 * @describe response基类
 * @email gcicada@163.com
 */
public class BaseResponse<T> {

    private int error_code;

    private String reason;

    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
