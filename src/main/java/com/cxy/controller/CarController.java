package com.cxy.controller;

import com.alibaba.fastjson.JSON;
import com.cxy.service.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

/**
 * Created by chengxy on 2018/3/27.
 */
@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private ICarService carService;

    private Logger logger = LoggerFactory.getLogger(CarController.class);

    @RequestMapping(value = "selectCar", method = RequestMethod.POST)
    public String selectCar(@RequestBody String param) {
        logger.info(param+"传入的参数");
        JSONObject jsonObject = JSONObject.parseObject(param);
        int id = (int) jsonObject.get("id");
        logger.info(id+"是传入进来的id");
        //int id = 1;
        return carService.selectCar(id).toString();

    }

    @RequestMapping("/insertCar")
    public void insertCar(@RequestBody String param) {
        JSONObject jsonObject = JSON.parseObject(param);
        String carName = (String) jsonObject.get("carName");
        BigDecimal carPrice = new BigDecimal((String) jsonObject.get("carPrice"));
        carService.insertCar(carName, carPrice);
    }

    @RequestMapping("/updateCar")
    public void updateCar(@RequestBody String param) {
        JSONObject jsonObject = JSON.parseObject(param);
        int id = (int) jsonObject.get("id");
        String carName = (String) jsonObject.get("carName");
        BigDecimal carPrice = new BigDecimal((String) jsonObject.get("carPrice"));
        carService.updateCar(carName, carPrice, id);
    }

    @RequestMapping("/deleteCar")
    public int deleteCar(@RequestBody String param) {
        JSONObject jsonObject = JSON.parseObject(param);
        int id = (int) jsonObject.get("id");
        carService.deleteCar(id);
        return 1;
    }

}
