package com.hz.research.server.impl;

import com.hz.research.dao.UserMapper;
import com.hz.research.model.User;
import com.hz.research.model.UserPwdChangeLog;
import com.hz.research.server.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Isolation;

@Service("UserService")
public class UserServiceImpl  implements IUserService {
    @Autowired
    UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * 事务失效的例子
     * 若同一类中的其他没有@Transactional 注解的方法内部调用有@Transactional 注解的方法
     * 事务会失效。
     * 解决办法就是这里也要加个事务的注解。或使用AspectJ
     * @param userId
     * @return
     */
    //@Transactional
    @Override
    public boolean resetUserPWD(int userId){
        return changeUserPWD(userId,"123");
    }

    /**
     * 事务的例子：修改密码及记录log
     * 场景：坑爹的祖传项目没有给log设置自增主键，该日志表id要求用数字。
     * 要求修改密码并插入log，插入log失败就回滚。
     *
     * SELECT * FROM study.user_pwd_change_log order by logid desc;
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

        int pwdLogId=userMapper.selectNextPWDLogId();
       // try {
            UserPwdChangeLog log = new UserPwdChangeLog();
            //log.setLogid(pwdLogId); //正确的代码
            log.setLogid(pwdLogId - 1);        //错误代码：故意让主键重复 学习事务,log,aop
            log.setUserid(userId);
            log.setAddwho(String.valueOf(userId));
            log.setPwdold(userOld.getPassword());
            log.setPwdnew(pwd);
            userMapper.insertPwdChangeLog(log);
            /*
        }catch(Exception e){
            logger.info("系统数据库异常:插入pwd日志异常 logid{}",pwdLogId);
            return false;
        }*/
        return true;
    }
}
