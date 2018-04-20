package com.cxy.controller;

import com.cxy.model.User;
import com.cxy.service.IUserService;
import com.cxy.utils.RequestRealIp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
     * */
    @PostMapping("/saveUser")
    public void userRegister(@RequestBody User user, HttpServletRequest request) {

        String requestRealIp = RequestRealIp.getRequestRealIp(request);
        user.setRegisterIp(requestRealIp);
        user.setCreateTime(new Date());
        synchronized (this) {
            Long userId = userService.queryLastUserId();
            if (userId == null || userId < 10000L){
                throw new RuntimeException("系统数据出错，请稍后再试，或联系管理员");
            }
            user.setUserId(userId + 1);
            userService.saveUser(user);
        }

    }

    /**
     * 查询用户信息
     * */
    @GetMapping("/queryUserByUserId")
    public User queryUser(Long userId) {
        return userService.queryUserByUserId(userId);
    }

}
