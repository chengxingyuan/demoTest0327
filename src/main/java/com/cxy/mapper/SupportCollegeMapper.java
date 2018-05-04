package com.cxy.mapper;

import com.cxy.model.SupportCollege;
import org.springframework.stereotype.Component;

/**
 * @author chengxy
 * @date 2018/5/3 16:49
 */
@Component
public interface SupportCollegeMapper {

    void insertSupportCollege(SupportCollege supportCollege);
}
