package com.cxy.service.impl;

import com.cxy.mapper.SupportUserMapper;
import com.cxy.model.User;
import com.cxy.service.ISupportUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengxy
 * @date 2018/5/4 14:27
 */
@Service
public class SupportUserImpl implements ISupportUser {

    @Autowired
    private SupportUserMapper supportUserMapper;

    @Override
    public void insertSupportUser(User user) {
        supportUserMapper.insertSupportUser(user);
    }
}
