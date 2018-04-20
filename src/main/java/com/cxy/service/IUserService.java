package com.cxy.service;

import com.cxy.model.User;

/**
 * @author chengxy
 * @date 2018/4/19 14:50
 */
public interface IUserService {

    void saveUser(User user);

    User queryUserByUserId(Long userId);

    Long queryLastUserId();
}
