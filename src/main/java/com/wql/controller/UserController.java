package com.wql.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wql.pojo.Message;
import com.wql.pojo.User;
import com.wql.service.UserService;
import com.wql.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")

public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    /**
     * 注册
     *
     * @param id
     * @param name
     * @param tel
     * @param password
     * @return
     */
    @RequestMapping(value = "/signUp", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String userSignUp(@RequestParam("username") String id,
                             @RequestParam("name") String name,
                             @RequestParam("telephone") String tel,
                             @RequestParam("pass") String password) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(id + name + tel + password);
        User user = new User(id, name, tel, password, 1);
        String result = userService.userSignUp(user);
        map.put(SystemConstant.MESSAGE, result);

        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

    /**
     * 用户登录
     *
     * @param id
     * @param password
     * @param role
     * @return
     */
    @RequestMapping(value = "/logIn", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String userLogIn(@RequestParam("username") String id,
                            @RequestParam("password") String password,
                            @RequestParam("role") String role) {
        Map<String, Object> map = new HashMap<>();
        User user;
        if (role.equals(SystemConstant.USER)) {
            user = userService.userLogIn(id);
        } else {
            user = userService.adminLogIn(id);
        }
        if (user == null) {
            //用户不存在
            map.put(SystemConstant.MESSAGE, "用户不存在");
        } else if(user.getState()==0) {
            map.put(SystemConstant.MESSAGE, "用户被拉黑");
        }
        else if (!user.getPassword().equals(password)) {
            //密码错误
            map.put(SystemConstant.MESSAGE, "密码错误");
        } else {
            //登录成功
            map.put(SystemConstant.MESSAGE, SystemConstant.SUCCESS);
        }
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

    /**
     * 找回密码
     *
     * @param id
     * @param tel
     * @return
     */
    @RequestMapping(value = "/passwordRetrieve", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String passwordRetrieve(@RequestParam("username") String id,
                                   @RequestParam("tel") String tel) {
        Map<String, Object> map = userService.passwordRetrieve(id, tel);

        return JSON.toJSONString(map);
    }

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @return
     */
    @RequestMapping(value = "/passwordModify", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String passwordModify(@RequestParam("id") String id,
                                 @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(id + password);
        String res = userService.passwordModify(password, id);
        map.put(SystemConstant.MESSAGE, res);

        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/userDataModify", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String userDataModify(@RequestParam("id") String id,
                                 @RequestParam("name") String name,
                                 @RequestParam("tel") String tel,
                                 @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<>();
        String res = userService.userDataModify(id,name,tel,password);
        map.put(SystemConstant.MESSAGE, res);

        return JSON.toJSONString(map);
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @RequestMapping(value = "/allUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllUser() {
        List<User> list = userService.getAllUser();
        return JSONArray.toJSONString(list);
    }

    /**
     * 根据id获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/searchUserById", produces = "application/json;charset=utf-8")  //需要返回List<User>
    @ResponseBody
    public String searchUserById(@RequestParam("id") String id) {
        System.out.println(id);
        User user = userService.getUserById(id);
        if (user == null) return JSONArray.toJSONString("没有该用户");
        else {
            List<User> list = new ArrayList<>();
            list.add(user);
            return JSONArray.toJSONString(list);
        }

    }

    @RequestMapping(value = "/UserById", produces = "application/json;charset=utf-8")  //返回User
    @ResponseBody
    public String getUserById(@RequestParam("id") String id) {
        User user = userService.getUserById(id);
        if (user == null) return JSONArray.toJSONString("没有该用户");
        else {
            return JSONArray.toJSONString(user);
        }
    }


    /**
     * 根据id拉黑用户
     *
     * @return
     */
    @RequestMapping(value = "/blackUserById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String blackUserById(@RequestParam("id") String id) {
        Map<String, Object> map = new HashMap<>();

        String res = userService.blackUserById(id);
        map.put(SystemConstant.MESSAGE, res);

        return JSON.toJSONString(map);
    }

    /**
     * 根据id取消拉黑用户
     *
     * @return
     */
    @RequestMapping(value = "/whiteUserById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String whiteUserById(@RequestParam("id") String id) {
        Map<String, Object> map = new HashMap<>();

        String res = userService.whiteUserById(id);
        map.put(SystemConstant.MESSAGE, res);

        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/deleteUserById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteUserById(@RequestParam("id") String id) {
        Map<String, Object> map = new HashMap<>();
        String res = userService.deleteUserById(id);
        map.put(SystemConstant.MESSAGE, res);
        return JSON.toJSONString(map);
    }

}
