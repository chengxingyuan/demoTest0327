package com.cxy.base;

import com.alibaba.fastjson.JSON;
import com.cxy.common.ResponseCodes;
import com.cxy.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chengxy
 * @date 2018/4/28 9:00
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected static BaseResponse response = new BaseResponse();

    /**
     * 操作成功
     * */
    protected static BaseResponse getSuccessResponse() {
        response.setCode(ResponseCodes.SUCCESS.getCode());
        response.setMessage(ResponseCodes.SUCCESS.getMessage());
        return response;
    }
    /**
     * 操作失败，参数：失败原因
     * */
    protected  BaseResponse getFalseResponse(String code,String message){
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 参数不能为空
     */
    protected BaseResponse getNotNullResponse(){
        response.setCode(ResponseCodes.ParameterCanNotIsNull.getCode());
        response.setMessage(ResponseCodes.ParameterCanNotIsNull.getMessage());
        return response;
    }

    /**
     * 结果为空
     * */
    protected BaseResponse resultIsNullResponse(){
        response.setCode(ResponseCodes.ResultIsNull.getCode());
        response.setMessage(ResponseCodes.ResultIsNull.getMessage());
        return response;
    }

    /**
     * 用户信息出错
     * */
    protected BaseResponse userInfoError(){
        response.setCode(ResponseCodes.UserIsNull.getCode());
        response.setMessage(ResponseCodes.UserIsNull.getMessage());
        return response;
    }
}
