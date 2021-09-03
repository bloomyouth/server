package com.wql.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wql.pojo.Messages;
import com.wql.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    @Qualifier("MessageServiceImpl")
    private MessageService messageService;

    @RequestMapping(value = "/allMessage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryAllMessage(){
        List<Messages> list=messageService.queryAllMessage();
        String str = JSONArray.toJSONString(list);
        System.out.println(str);
        System.out.println("ok");
        return JSONArray.toJSONString(list);
    }

    @RequestMapping(value = "/test")
    public String test(){
        List<Messages> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            Messages messages=new Messages();
            messages.setId(i+1);
            messages.setTime(new Date().toString());
            messages.setName("wql");
            messages.setState("未认领");
            messages.setType(1);
            list.add(messages);
        }
        String jsonString = JSONArray.toJSONString(list);
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        System.out.println(jsonArray);
        System.out.println("成功");
        return "test";
    }

}
