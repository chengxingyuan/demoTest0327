package com.cxy.model;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

/**
 * Created by chengxy on 2018/3/27.
 */
public class Car {

    private int id;

    private String carName;

    private BigDecimal carPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                '}';
    }
}
