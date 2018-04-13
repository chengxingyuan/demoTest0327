package com.cxy.job;

import com.cxy.service.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by chengxy on 2018/3/28.
 */
@Component
public class AutoDeleteDirtyDataJob {

    private final static Logger logger = LoggerFactory.getLogger(AutoDeleteDirtyDataJob.class);
    @Autowired
    private ICarService carService;

    //@Scheduled(cron = "0/15 * * * * ?")
    public void deleteDirtyData(){
        long id = java.lang.Thread.currentThread().getId();
        logger.info(id+"开始删除脏数据、、、、、、11--");
        carService.deleteDirtyData();
    }
}
