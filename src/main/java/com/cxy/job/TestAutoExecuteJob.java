package com.cxy.job;

import com.cxy.service.ICarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by chengxy on 2018/3/28.
 */
@Component
public class TestAutoExecuteJob {
    private Logger logger = LoggerFactory.getLogger(TestAutoExecuteJob.class);
    @Autowired
    private ICarService carService;

    //@Scheduled(cron = "0/5 * * * * ?")
    public void autoExecuteInsertCar() {
        long id = Thread.currentThread().getId();
        logger.info(id + "开始执行...");
        String carName = "car" + Math.random();
        BigDecimal carPrice = new BigDecimal(100 + Math.random());
        carService.insertCar(carName, carPrice);
    }
}
