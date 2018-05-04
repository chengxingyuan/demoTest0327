package com.cxy.mapper;

import com.cxy.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author chengxy
 * @date 2018/5/4 14:05
 */
@Repository
public interface SupportUserMapper {

    void insertSupportUser(User user);
}
