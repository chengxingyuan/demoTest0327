package com.cxy.controller;

import com.cxy.base.BaseController;
import com.cxy.common.ResponseCodes;
import com.cxy.exception.SystemException;
import com.cxy.model.User;
import com.cxy.response.BaseResponse;
import com.cxy.service.IUserService;
import com.cxy.utils.MD5Utils;
import com.cxy.utils.RequestRealIp;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/19 11:23
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 保存用户信息(用户注册)
     */
    @PostMapping("/saveUser")
    public BaseResponse userRegister(@RequestBody User user, HttpServletRequest request) {

        BaseResponse response = new BaseResponse();
        if (user == null) {
            response.setCode(ResponseCodes.UserIsNull.getCode());
            response.setMessage(ResponseCodes.UserIsNull.getMessage());
            return response;
        }
        //验证手机号是否已被注册
        List<String> phoneNumList = userService.phoneList();
        if (phoneNumList != null && phoneNumList.size() > 0) {
            for (int i = 0; i < phoneNumList.size(); i++) {
                if (phoneNumList.get(i).contains(user.getPhoneNum())) {
                    response.setCode(ResponseCodes.PhoneNumAlreadyExist.getCode());
                    response.setMessage(ResponseCodes.PhoneNumAlreadyExist.getMessage());
                    return response;
                }
            }
        }

        String requestRealIp = RequestRealIp.getRequestRealIp(request);
        String passWord = user.getPassWord();
        if (passWord != null) {
            passWord = MD5Utils.MD5(passWord);
            user.setPassWord(passWord);
        }
        user.setRegisterIp(requestRealIp);
        user.setCreateTime(new Date());
        synchronized (this) {
            Long userId = userService.queryLastUserId();
            if (userId == null || userId < 10000L) {
                response.setMessage(ResponseCodes.SystemError.getMessage());
                return response;
            }
            user.setUserId(userId + 1);
            userService.saveUser(user);
        }
        return getSuccessResponse();
    }

    /**
     * 验证登录，登录名可以是userId,phoneNum
     */
    @PostMapping("/loginAccount")
    public BaseResponse loginAccount(User user, HttpServletRequest request) {
        if (user == null || user.getUserId() == null){
            return getNotNullResponse();
        }
        //如果传过来的登录名超长 说明是手机号登录
        if (user.getUserId() > 9999999999L){
            user.setPhoneNum(user.getUserId().toString());
            user.setUserId(null);
        }
        logger.info("请求参数{}",user);
        User userInfo = userService.queryUser(user);
        if (userInfo == null ) {
            return getFalseResponse(ResponseCodes.PasswordFalse.getCode(),ResponseCodes.PasswordFalse.getMessage());
        }
        logger.info("用户信息{}",userInfo);
        String passWord = MD5Utils.MD5(user.getPassWord());
        if (!passWord.equals(userInfo.getPassWord())) {
            return getFalseResponse(ResponseCodes.PasswordFalse.getCode(),ResponseCodes.PasswordFalse.getMessage());
        }
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);
        return getSuccessResponse();
    }

    /**
     * 用户退出，销毁session
     */
    public BaseResponse loginOut(@RequestBody HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return getSuccessResponse();
    }


    /**
     * 查询用户信息
     */
    @GetMapping("/queryUserByUserId")
    public User queryUser(Long userId) {
        return userService.queryUserByUserId(userId);
    }

    /**
     * 更改密码
     */
    @PostMapping("changePassword")
    public BaseResponse changePassword(@RequestBody User user) {
        if (user == null || user.getUserId() == null) {
            return getNotNullResponse();
        }

        String passWord = user.getPassWord();
        if (StringUtils.isEmpty(passWord) || passWord.length() < 6) {
            return getFalseResponse(ResponseCodes.PasswordCanNotTooShort.getCode(),ResponseCodes.PasswordCanNotTooShort.getMessage());
        }
        passWord = MD5Utils.MD5(passWord);
        user.setPassWord(passWord);
        userService.updateUser(user);
        return getSuccessResponse();
    }

}
