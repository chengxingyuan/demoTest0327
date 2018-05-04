package com.cxy.controller;

import com.cxy.model.User;
import com.cxy.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chengxy
 * @date 2018/4/25 14:08
 */
@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String welcome(ModelMap map) {
       // User user = UserContext.getUser();
       // logger.info(user.getUserId()+"是当前用户Id");
        map.put("test", "无敌1111");
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap map) {
        return "login";
    }
}
