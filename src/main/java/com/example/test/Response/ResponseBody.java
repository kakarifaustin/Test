package com.example.test.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ResponseBody<T> {
    private boolean success;
    private String message;
    private T result;

    public ResponseBody(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseBody(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public ResponseBody(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    
    
}
