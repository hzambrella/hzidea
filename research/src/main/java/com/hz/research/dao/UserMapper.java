package com.hz.research.dao;

import com.hz.research.model.User;
import com.hz.research.model.UserPwdChangeLog;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertPwdChangeLog(UserPwdChangeLog record);

    int selectNextPWDLogId();
}