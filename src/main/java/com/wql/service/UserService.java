package com.wql.service;

import com.wql.pojo.Message;
import com.wql.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    String userSignUp(User user);

    User userLogIn(String id);

    User adminLogIn(String id);

    String passwordModify(String password,String id);

    String userDataModify(String id,String name,String tel,String password);

    Map<String, Object> passwordRetrieve(String id, String tel);

    List<User> getAllUser();

    User getUserById(String id);

    String deleteUserById(String id);

    String blackUserById(String id);

    String whiteUserById(String id);
}
