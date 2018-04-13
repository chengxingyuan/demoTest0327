package com.cxy.mapper;

import com.cxy.model.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by chengxy on 2018/3/27.
 */
public interface CarMapper {

    @Select("select * from t_car where id = #{id}")
    Car selectCar(int id);

    @Insert("insert into t_car (carName,carPrice) values(#{carName},#{carPrice})")
    void insertCar(@Param("carName") String carName, @Param("carPrice") BigDecimal carPrice);

//    @Update("update t_car set carName = #{carName},carPrice = #{carPrice} where id = #{id}")
//    void updateCar(@Param("carName")String carName,@Param("carPrice")BigDecimal carPrice,@Param("id")int id);

    //@Update("update t_car set carName = #{carName},carPrice = #{carPrice} where id = #{id}")
    void updateCar(@Param("carName")String carName,@Param("carPrice")BigDecimal carPrice,@Param("id")int id);

    void deleteCar(int id);

    void deleteDirtyData();
}
