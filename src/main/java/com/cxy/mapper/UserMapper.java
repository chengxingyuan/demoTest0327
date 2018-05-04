package com.cxy.mapper;

import com.cxy.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/19 15:03
 */
@Component
public interface UserMapper {
    /**
     * 保存用户信息
     * @param user 用户实体bean
     * */
    void saveUser(User user);

    /**
     * 查询用户信息
     * @param userId 用户id
     * @return user 详细信息
     * */
    User queryUserByUserId(Long userId);

    /**
     * 查询用户信息加锁
     * @param userId 用户id
     * @return user 详细信息
     * */
    User queryUserByUserIdForUpdate(Long userId);

    /**
     * 查询userId进行自增长
     * @return 上一个注册人的userId
     * */
    Long queryLastUserId();

    User queryUser(User user);

    /**
     * 查询所有已注册的手机号
     * */
    List<String> queryPhoneList();

    /**
     * 更新用户信息
     * */
    int updateUserInfo(User user);
}
