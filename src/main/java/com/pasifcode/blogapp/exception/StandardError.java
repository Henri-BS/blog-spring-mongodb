package com.pasifcode.blogapp.exception;

import java.io.Serial;
import java.io.Serializable;

public class StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long timestramp;
    private Integer status;
    private String error;
    private String message;
    private String requestURI;

    public StandardError() {
    }

    public StandardError(Long timestramp, Integer status, String error, String message, String requestURI) {
        this.timestramp = timestramp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.requestURI = requestURI;
    }

    public Long getTimestramp() {
        return timestramp;
    }

    public void setTimestramp(Long timestramp) {
        this.timestramp = timestramp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }
}
