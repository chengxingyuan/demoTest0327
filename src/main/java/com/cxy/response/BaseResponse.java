package com.cxy.response;

/**
 * @author chengxy
 * @date 2018/4/26 8:58
 */
public class BaseResponse {
    private String code;
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
