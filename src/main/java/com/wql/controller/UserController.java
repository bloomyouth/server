package com.wql.controller;

import com.alibaba.fastjson.JSON;
import com.wql.pojo.Users;
import com.wql.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @PostMapping(value = "/user",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkUser(@RequestBody String param){
        System.out.println("请求成功");
        System.out.println(param);
        Users users = JSON.parseObject(param,Users.class);
        System.out.println(users.getUsername());
//        System.out.println(password);
        Users users1=userService.searchUser("useradmin",users.getUsername());
        if(users1==null) return "用户不存在";
        else if(!users1.getPassword().equals(users.getPassword())) return "密码错误";
        return "登录成功";

    }

    @PostMapping(value = "/manager",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkManager(@RequestBody String param){
        System.out.println("请求成功");
        System.out.println(param);
        Users users = JSON.parseObject(param,Users.class);
        System.out.println(users.getUsername());
//        System.out.println(password);
        Users users1=userService.searchUser("manager",users.getUsername());
        if(users1==null) return "用户不存在";
        else if(!users1.getPassword().equals(users.getPassword())) return "密码错误";
        return "登录成功";

    }


}
