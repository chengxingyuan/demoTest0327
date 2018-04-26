package com.cxy.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chengxy
 * @date 2018/4/26 9:03
 */
public enum ResponseCodes {

    SUCCESS("00","操作成功"),
    PhoneNumAlreadyExist("10001","该手机号已经注册"),
    UserIsNull("10000","用户信息不能为空");

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回码说明
     */
    private String message;

    ResponseCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过code获取对应的ResponseCodes
     * @param code 错误码
     * @return 响应码对应的ResponseCodes枚举
     */
    public static ResponseCodes getResponseByCode(String code){
        if(code == null || StringUtils.isBlank(code)){
            throw new NullPointerException("响应编码为空");
        }

        for(ResponseCodes responseCode : ResponseCodes.values()){
            if(responseCode.getCode().equals(code)){
                return responseCode;
            }
        }

        throw new IllegalArgumentException("未能找到匹配的ResponseCodes:" + code);
    }

    /**
     * 获取响应编码
     * @return
     */
    public String getCode(){
        return this.code;
    }

    /**
     * 获取编码对应消息
     * @return
     */
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) {this.message = message;}
}
