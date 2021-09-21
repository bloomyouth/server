package com.wql.dao;

import com.wql.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //新增
    //新增用户
    void addUser(User user);

    //删除
    //删除用户
    void delUser(String id);

    //修改
    //修改用户密码
    void passwordModify(@Param("password") String password,@Param("id") String id);

    void userDataModify(@Param("id") String id,@Param("name") String name,@Param("tel") String tel,@Param("password") String password);

    //根据id将用户拉黑
    void blackUserById(String id);

    //根据id将用户取消拉黑
    void whiteUserById(String id);

    //查询
    //按用户id查找用户
    User getUserById(String id);

    //按管理员id查找管理员
    User getAdminById(String id);

    //查询所有用户
    List<User> getAllUser();



}
