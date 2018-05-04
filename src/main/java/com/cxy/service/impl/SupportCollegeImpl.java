package com.cxy.service.impl;

import com.cxy.mapper.SupportCollegeMapper;
import com.cxy.model.SupportCollege;
import com.cxy.service.ISupportCollege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengxy
 * @date 2018/5/3 16:47
 */
@Service
public class SupportCollegeImpl implements ISupportCollege {

    @Autowired
    private SupportCollegeMapper supportCollegeMapper;

    @Override
    public void insertSupportRecord(SupportCollege supportCollege) {
        supportCollegeMapper.insertSupportCollege(supportCollege);
    }
}
