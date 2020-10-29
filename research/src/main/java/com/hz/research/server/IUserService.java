package com.hz.research.server;

public interface IUserService {
    boolean changeUserPWD(int userId,String pwd);
    boolean resetUserPWD(int userId);
}
