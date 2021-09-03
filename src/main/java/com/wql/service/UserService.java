package com.wql.service;

import com.wql.pojo.Users;

public interface UserService {
    Users searchUser(String tableName,String username);
}
