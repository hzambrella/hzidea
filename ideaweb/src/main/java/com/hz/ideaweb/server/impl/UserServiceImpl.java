package com.hz.ideaweb.server.impl;

import com.hz.ideaweb.dao.UserMapper;
import com.hz.ideaweb.model.User;
import com.hz.ideaweb.model.UserPwdChangeLog;
import com.hz.ideaweb.server.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl  implements IUserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 事务的例子：修改密码及log
     * 场景：坑爹的祖传项目没有给log设置自增主键，且要求用数字。
     * @param userId
     * @param pwd
     * @return
     */
    @Transactional
    @Override
    public boolean changeUserPWD(int userId, String pwd) {
        User userOld=userMapper.selectByPrimaryKey(userId);
        User user=new User();
        user.setId(Integer.valueOf(userId));
        user.setPassword(pwd);
        userMapper.updateByPrimaryKeySelective(user);

        int logid=userMapper.selectNextPWDLogId();

        UserPwdChangeLog log=new UserPwdChangeLog();
        log.setLogid(logid);
        log.setUserid(userId);
        log.setAddwho(String.valueOf(userId));
        log.setPwdold(userOld.getPassword());
        log.setPwdnew(pwd);
        userMapper.insertPwdChangeLog(log);
        return true;
    }
}
