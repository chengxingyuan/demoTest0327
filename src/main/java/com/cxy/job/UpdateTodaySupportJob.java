package com.cxy.job;

import com.cxy.model.User;
import com.cxy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chengxy
 * @date 2018/4/26 10:36
 */
@Component
public class UpdateTodaySupportJob {
    private Logger logger = LoggerFactory.getLogger(UpdateTodaySupportJob.class);

    @Autowired
    private IUserService userService;
    /**
     * 每天6点刷新每日可用点赞数
     * */
    @Scheduled(cron = "0 0 6 * * ?")
    public void updateAvailableSupportEveryDay(){
        logger.info("触发刷新点赞数");
        User user = new User();
        //每天每个人免费可用点赞数为10
        user.setTodayAvailableSupport(10);
        userService.updateUser(user);
    }
}
