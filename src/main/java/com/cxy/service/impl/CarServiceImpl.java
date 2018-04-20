package com.cxy.service.impl;

import com.cxy.mapper.CarMapper;
import com.cxy.model.Car;
import com.cxy.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by chengxy on 2018/3/27.
 */
@Service
public class CarServiceImpl implements ICarService{

    @Autowired
     private CarMapper carMapper;

    @Override
    public Car selectCar(int id) {
        return carMapper.selectCar(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertCar(String carName, BigDecimal carPrice){

        carMapper.insertCar(carName,carPrice);
        Car car = carMapper.selectCar(105);
        //System.out.println(car.getCarName());



    }

    @Override
    public void updateCar(String carName,BigDecimal carPrice,int id){
        carMapper.updateCar(carName,carPrice,id);
    }

    @Override
    public void deleteCar(int id) {
        carMapper.deleteCar(id);
    }

    /**
     * 定时删除脏数据
     * */
    @Override
    public void deleteDirtyData(){
        carMapper.deleteDirtyData();
    }
}
