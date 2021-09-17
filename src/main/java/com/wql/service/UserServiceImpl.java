package com.wql.service;

import com.wql.dao.UserMapper;
import com.wql.pojo.Message;
import com.wql.pojo.User;
import com.wql.util.SystemConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper=userMapper;
    }

    @Override
    public String userSignUp(User user) {
        if(userMapper.getUserById(user.getId())!=null){
            //注册失败，用户id已存在
            return "注册失败，用户id已存在";
        }
        else{
            //注册成功
            this.userMapper.addUser(user);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public User userLogIn(String id) {
        return this.userMapper.getUserById(id);
    }

    @Override
    public User adminLogIn(String id) {
        return this.userMapper.getAdminById(id);
    }

    @Override
    public String passwordModify(String password,String id) {
        if(userMapper.getUserById(id)==null){
            //错误，用户id不存在
            return "错误，用户id不存在";
        }
        else{
            //注册成功
            userMapper.passwordModify(password,id);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public String userDataModify(String id, String name, String tel,String password) {
        if(userMapper.getUserById(id)==null){
            //错误，用户id不存在
            return "错误，用户id不存在";
        }
        else{
            userMapper.userDataModify(id,name,tel,password);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public Map<String, Object> passwordRetrieve(String id, String tel) {
        Map<String, Object> map=new HashMap<>();
        if(userMapper.getUserById(id)==null){
            //错误，用户id不存在
            map.put(SystemConstant.MESSAGE,"错误，用户id不存在");
            map.put(SystemConstant.PASSWORD,null);
        }
        else{
            User user=userMapper.getUserById(id);
            if (!user.getTel().equals(tel)) {
                //错误，用户手机号错误
                map.put(SystemConstant.MESSAGE,"错误，用户手机号错误");
                map.put(SystemConstant.PASSWORD,null);
            }
            else {
                //密码找回成功
                map.put(SystemConstant.MESSAGE,SystemConstant.SUCCESS);
                map.put(SystemConstant.PASSWORD,user.getPassword());
            }
        }
        return map;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public String blackUserById(String id) {
        if(userMapper.getUserById(id)==null){
            return "错误，用户不存在";
        }
        else{
            userMapper.blackUserById(id);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public String whiteUserById(String id) {
        if(userMapper.getUserById(id)==null){
            return "错误，用户不存在";
        }
        else{
            userMapper.whiteUserById(id);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public User getUserById(String id){
        return userMapper.getUserById(id);
    }

    @Override
    public String deleteUserById(String id){
        if(userMapper.getUserById(id)==null) return "错误,用户不存在";
        else{
            userMapper.delUser(id);
            return "success";
        }
    }
}


