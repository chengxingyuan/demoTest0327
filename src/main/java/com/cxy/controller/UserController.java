package com.cxy.controller;

import com.cxy.common.ResponseCodes;
import com.cxy.exception.SystemException;
import com.cxy.model.User;
import com.cxy.response.BaseResponse;
import com.cxy.service.IUserService;
import com.cxy.utils.MD5Utils;
import com.cxy.utils.RequestRealIp;
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
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 保存用户信息
     */
    @PostMapping("/saveUser")
    public BaseResponse userRegister(@RequestBody User user, HttpServletRequest request) {

        BaseResponse response = new BaseResponse();
        if (user == null){
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
                throw new RuntimeException("系统数据出错，请稍后再试，或联系管理员");
            }
            user.setUserId(userId + 1);
            userService.saveUser(user);
        }
        response.setCode(ResponseCodes.SUCCESS.getCode());
        response.setMessage(ResponseCodes.SUCCESS.getMessage());
        return response;
    }

    /**
     * 验证登录，登录名可以是userId,phoneNum
     */
    @PostMapping("/loginAccount")
    public String loginAccount(@RequestBody User user, HttpServletRequest request) {
        logger.info(user.getUserId() + "======================" + user.getPassWord());

        User userInfo = userService.queryUser(user);
        logger.info(user.toString() + "------------------------------------");
        if (userInfo == null) {
            throw new SystemException("用户不存在");
        }
        String passWord = MD5Utils.MD5(user.getPassWord());
        if (!passWord.equals(userInfo.getPassWord())) {
            throw new SystemException("密码错误");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUserId());
        return "success";
    }

    /**
     * 用户退出，销毁session
     */
    public void loginOut(@RequestBody HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
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
     * */
    @PostMapping("changePassword")
    public BaseResponse changePassword(){
        BaseResponse res = new BaseResponse();


        return res;
    }

}
