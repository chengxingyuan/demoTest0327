package com.cxy.service.impl;

import com.cxy.mapper.UserMapper;
import com.cxy.model.User;
import com.cxy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chengxy
 * @date 2018/4/19 14:51
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public User queryUserByUserId(Long userId) {
        return userMapper.queryUserByUserId(userId);
    }

    @Override
    public Long queryLastUserId() {
        return userMapper.queryLastUserId();
    }


}
