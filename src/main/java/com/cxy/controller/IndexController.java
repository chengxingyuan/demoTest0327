package com.cxy.controller;

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
    public String welcome(ModelMap map){
        logger.info("访问index页");
        map.put("test","无敌1111");
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap map){
        return "login";
    }
}
