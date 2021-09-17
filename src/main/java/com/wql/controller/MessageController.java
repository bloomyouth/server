package com.wql.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wql.pojo.Message;
import com.wql.pojo.User;
import com.wql.service.MessageService;
import com.wql.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value="/message")
public class MessageController {

    @Autowired
    @Qualifier("MessageServiceImpl")
    private MessageService messageService;

    /**
     * 新增启事
     * @param messageId
     * @param messageType
     * @param objectName
     * @param objectType
     * @param messageDate
     * @param messageState
     * @param description
     * @param userId
     * @return
     */
    @RequestMapping(value = "/addMessage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addMessage(@RequestParam("messageId") int messageId,
                             @RequestParam("messageType") String messageType,
                             @RequestParam("objectName") String objectName,
                             @RequestParam("objectType") String objectType,
                             @RequestParam("messageDate") String messageDate,
                             @RequestParam("messageState") String messageState,
                             @RequestParam("description") String description,
                             @RequestParam("userId") String userId) {
        Map<String,Object> map=new HashMap<>();

        Message message=new Message(messageId,messageType,objectType,objectName,messageDate,SystemConstant.NEED_CHECK,description,userId);
        String res=messageService.addMessage(message);
        map.put(SystemConstant.MESSAGE,res);

        return JSON.toJSONString(map);
    }

    /**
     * 修改启事
     * @param messageId
     * @param messageType
     * @param objectName
     * @param objectType
     * @param messageDate
     * @param messageState
     * @param description
     * @param userId
     * @return
     */
    @RequestMapping(value = "/modifyMessage",produces = "application/json;charset=utf-8")
    public String modifyMessage(@RequestParam("messageId") int messageId,
                             @RequestParam("messageType") String messageType,
                             @RequestParam("objectName") String objectName,
                             @RequestParam("objectType") String objectType,
                             @RequestParam("messageDate") String messageDate,
                             @RequestParam("messageState") String messageState,
                             @RequestParam("description") String description,
                             @RequestParam("userId") String userId) {
        Map<String,Object> map=new HashMap<>();


        Message message=new Message(messageId,messageType,objectType,objectName,messageDate,SystemConstant.NEED_CHECK,description,userId);
        String res=messageService.modifyMessage(message);
        map.put(SystemConstant.MESSAGE,res);

        return JSON.toJSONString(map);
    }

    /**
     * 删除启事
     * @param messageId
     * @return
     */
    @RequestMapping(value = "/deleteMessage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteMessage(@RequestParam("messageId") int messageId) {
        Map<String,Object> map=new HashMap<>();

        String res=messageService.deleteMessage(messageId);
        map.put(SystemConstant.MESSAGE,res);

        return JSON.toJSONString(map);
    }

    /**
     * 获取所有启事信息
     * @return
     */
    @RequestMapping(value = "/getAllMessage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllMessage(){
        List<Message> list=messageService.getAllMessage();
        System.out.println(list);
        System.out.println(JSONArray.toJSONString(list));
        return JSONArray.toJSONString(list);
    }

    /**
     * 按用户id查找启事信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getMessageByUserId",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getMessageByUserId(@RequestParam("id") String id){
        List<Message> list=messageService.getMessageByUserId(id);
        return JSONArray.toJSONString(list);
    }

    /**
     * 根据id审核通过启事
     * @param messageId
     * @return
     */
    @RequestMapping(value = "/acceptMessageByUserId",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String acceptMessageByUserId(@RequestParam("messageId") int messageId){
        Map<String,Object> map=new HashMap<>();

        String res=messageService.acceptMessageByUserId(messageId);
        map.put(SystemConstant.MESSAGE,res);

        return JSONArray.toJSONString(map);
    }

    /**
     * 根据id审核拒绝启事
     * @param messageId
     * @return
     */
    @RequestMapping(value = "rejectMessageByUserId",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String rejectMessageByUserId(@RequestParam("messageId") int messageId){
        Map<String,Object> map=new HashMap<>();

        String res=messageService.rejectMessageByUserId(messageId);
        map.put(SystemConstant.MESSAGE,res);

        return JSONArray.toJSONString(map);
    }

    /**
     * 获取所有通过审核的启事信息
     * @return
     */
    @RequestMapping(value = "/getAllPassedMessage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getPassedAllMessage(){
        List<Message> list=messageService.getAllPassedMessage();
        return JSONArray.toJSONString(list);
    }

}
