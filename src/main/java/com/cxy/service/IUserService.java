package com.cxy.service;

import com.cxy.model.User;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/19 14:50
 */
public interface IUserService {

    void saveUser(User user);

    User queryUserByUserId(Long userId);

    Long queryLastUserId();

    User queryUser(User user);

    /**
     * 查询所有已注册的手机号
     * */
    List<String> phoneList();

    /**
     * 更新用户信息
     * */
    int updateUser(User user);
}
