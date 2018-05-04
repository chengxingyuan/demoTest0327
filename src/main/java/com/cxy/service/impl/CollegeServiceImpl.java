package com.cxy.service.impl;

import com.cxy.mapper.CollegeMapper;
import com.cxy.model.College;
import com.cxy.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/18 14:06
 */
@Service
public class CollegeServiceImpl implements ICollegeService{

    @Autowired
    CollegeMapper collegeMapper;
    /**
     * 根据首字母查询大学
     * */
    @Override
    public List<String> queryCollegeByInitial(String initial){
        return collegeMapper.queryCollegeByInitial(initial);
    }

    @Override
    public College queryCollegeDetailByName(String collegeName) {
        return collegeMapper.queryCollegeDetailByName(collegeName);
    }

    @Override
    public void updateCollegeInfo(College college) {
        collegeMapper.updateCollegeInfo(college);
    }

    @Override
    public College queryCollegeForUpdate(String whichCollege) {
        return collegeMapper.queryCollegeForUpdate(whichCollege);
    }
}
