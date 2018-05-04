package com.cxy.service.impl;

import com.cxy.mapper.UserMapper;
import com.cxy.model.User;
import com.cxy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public User queryUserByUserIdForUpdate(Long userId) {
        return userMapper.queryUserByUserIdForUpdate(userId);
    }

    @Override
    public Long queryLastUserId() {
        return userMapper.queryLastUserId();
    }

    @Override
    public User queryUser(User user) {
        return userMapper.queryUser(user);
    }

    @Override
    public List<String> phoneList() {
        return userMapper.queryPhoneList();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUserInfo(user);
    }


}
