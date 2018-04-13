package com.cxy.service;

import com.cxy.model.Car;

import java.math.BigDecimal;

/**
 * Created by chengxy on 2018/3/27.
 */
public interface ICarService {

    Car selectCar(int id);

    void insertCar(String carName,BigDecimal carPrice);

    void updateCar(String carName,BigDecimal carPrice,int id);

    void deleteCar(int id);

    /**
     * 定时删除脏数据
     * */
    void deleteDirtyData();


}
