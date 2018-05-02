package com.cxy.controller;

import com.cxy.base.BaseController;
import com.cxy.model.College;
import com.cxy.model.User;
import com.cxy.service.ICollegeService;
import com.cxy.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/18 13:51
 */
@RestController
@RequestMapping("college")
public class CollegeController extends BaseController{
    @Autowired
    ICollegeService collegeService;

    /**
     * 根据首字母查询，以该首字母开头的大学
     * */
    @RequestMapping("/queryCollegeByInitial")
    public List<String> queryCollegeByInitial(String initial){
        return collegeService.queryCollegeByInitial(initial);
    }

    /**
     * 根据大学名查学校详情
     * */
    @RequestMapping("/queryCollegeDetailByName")
    public College queryCollegeDetailByName(String collegeName){
        User user = UserContext.getUser();
        return collegeService.queryCollegeDetailByName(collegeName);
    }
}
