package com.cxy.mapper;

import com.cxy.model.College;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengxy
 * @date 2018/4/18 14:19
 */
@Component
public interface CollegeMapper {

    List<String> queryCollegeByInitial(String initial);

    College queryCollegeDetailByName(String collegeName);

    void updateCollegeInfo(College college);

    College queryCollegeForUpdate(String whichCollege);

}
