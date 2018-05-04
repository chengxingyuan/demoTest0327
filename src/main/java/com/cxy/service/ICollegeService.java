package com.cxy.service;

import com.cxy.model.College;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/18 14:05
 */
public interface ICollegeService {

    List<String> queryCollegeByInitial(String initial);

    College queryCollegeDetailByName(String collegeName);

    void updateCollegeInfo(College college);

    College queryCollegeForUpdate(String whichCollege);
}
