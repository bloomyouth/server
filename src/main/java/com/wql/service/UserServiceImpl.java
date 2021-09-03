package com.wql.service;

import com.wql.dao.UserMapper;
import com.wql.pojo.Users;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {this.userMapper=userMapper;}

    public Users searchUser(String tableName,String username){ return userMapper.searchUser(tableName,username);}


}


