package com.cxy.exception;

/**
 * @author chengxy
 * @date 2018/4/24 10:10
 */
public class SystemException extends RuntimeException{

    private String errorCode;

    private String errorMessage;

    public SystemException() {
    }
    public SystemException(String message) {
        super();
        errorMessage = message;
    }

    public SystemException(String code, String message){
        super();
        errorCode = code;
        errorMessage = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
