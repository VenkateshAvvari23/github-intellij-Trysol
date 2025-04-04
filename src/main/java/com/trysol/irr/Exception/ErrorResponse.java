package com.trysol.irr.Exception;

public class ErrorResponse {

    private String message;

    private Integer status;

    private String requestUrl;

    public ErrorResponse(String message, Integer status, String requestUrl) {
        this.message = message;
        this.status = status;
        this.requestUrl=requestUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", requestUrl='" + requestUrl + '\'' +
                '}';
    }
}
