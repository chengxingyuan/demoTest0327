package com.cxy.controller;

import com.cxy.base.BaseController;
import com.cxy.common.ResponseCodes;
import com.cxy.model.College;
import com.cxy.model.SupportCollege;
import com.cxy.model.User;
import com.cxy.response.BaseResponse;
import com.cxy.service.ICollegeService;
import com.cxy.service.ISupportCollege;
import com.cxy.service.IUserService;
import com.cxy.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/18 13:51
 */
@RestController
@RequestMapping("college")
public class CollegeController extends BaseController {
    @Autowired
    ICollegeService collegeService;

    @Autowired
    IUserService userService;

    @Autowired
    ISupportCollege supportCollegeImpl;

    /**
     * 根据首字母查询，以该首字母开头的大学
     */
    @RequestMapping("/queryCollegeByInitial")
    public List<String> queryCollegeByInitial(String initial) {
        return collegeService.queryCollegeByInitial(initial);
    }

    /**
     * 根据大学名查学校详情
     */
    @RequestMapping("/queryCollegeDetailByName")
    public College queryCollegeDetailByName(String collegeName) {

        return collegeService.queryCollegeDetailByName(collegeName);
    }

    /**
     * 用户给大学点赞
     */
    @PostMapping("/supportCollege")
    public BaseResponse supportCollege(@RequestBody SupportCollege supportCollege) {
        if (supportCollege == null || supportCollege.getSupportNum() < 1) {
            return getNotNullResponse();
        }
        //判断点赞用户是否是当前登录用户
//        User userContext = UserContext.getUser();
//        if (userContext == null || userContext.getUserId() != supportCollege.getUserIdOfSupport()) {
//            return userInfoError();
//        }
        logger.info("为大学点赞入参：{}",supportCollege);
        User user = userService.queryUserByUserIdForUpdate(supportCollege.getUserIdOfSupport());
        if (user == null){
            return getFalseResponse(ResponseCodes.UserIsNull.getCode(),ResponseCodes.UserIsNull.getMessage());
        }
        College college = collegeService.queryCollegeForUpdate(supportCollege.getWhichCollege());
        if (college == null){
            return getFalseResponse(ResponseCodes.CollegeIsNull.getCode(),ResponseCodes.CollegeIsNull.getMessage());
        }

        //如果点赞数小于每日免费送的，使用免费赞
        if (user.getTodayAvailableSupport() >= supportCollege.getSupportNum()) {
            int newAvailableSupport = user.getTodayAvailableSupport() - supportCollege.getSupportNum();
            int newHistoryUsed = user.getHistoryUsedSupport() + supportCollege.getSupportNum();
            user.setTodayAvailableSupport(newAvailableSupport);
            user.setHistoryUsedSupport(newHistoryUsed);

            userService.updateUser(user);
            supportCollege.setSupportTime(new Date());
            supportCollegeImpl.insertSupportRecord(supportCollege);

            college.setSupportNum(college.getSupportNum()+supportCollege.getSupportNum());
            collegeService.updateCollegeInfo(college);
            return getSuccessResponse();

        } else if (supportCollege.getSupportNum() <= user.getTodayAvailableSupport() + user.getPayAvailableSupport()) {
            //点赞数小于免费的+付费的赞 先用免费赞，再用付费赞
            int supportNum = supportCollege.getSupportNum() - user.getTodayAvailableSupport();
            int paySupportNum = user.getPayAvailableSupport() - supportNum;

            user.setTodayAvailableSupport(0);
            user.setPayAvailableSupport(paySupportNum);
            user.setHistoryUsedSupport(user.getHistoryUsedSupport() + supportCollege.getSupportNum());
            userService.updateUser(user);

            supportCollege.setSupportTime(new Date());
            supportCollegeImpl.insertSupportRecord(supportCollege);
            college.setSupportNum(college.getSupportNum()+supportCollege.getSupportNum());
            collegeService.updateCollegeInfo(college);

            return getSuccessResponse();

        }
        //赞不足
        response.setCode(ResponseCodes.SupportNotEnough.getCode());
        response.setMessage(ResponseCodes.SupportNotEnough.getMessage());
        return response;
    }
}
