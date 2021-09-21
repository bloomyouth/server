package com.wql.dao;

import com.wql.pojo.Message;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.Date;
import java.util.List;

public interface MessageMapper {

    //增加
    //新增启事信息
    void addMessage(Message message);

    //删除
    //按照messageId删除启事信息
    void deleteMessage(int messageId);

    //修改
    //按照messageId修改启事信息
    void modifyMessage(Message message);

    //审核通过启事
    void acceptMessageById(int id);

    //审核拒绝启事
    void rejectMessageById(int id);

    //查询
    //获取所有启事信息
    List<Message> getAllMessage();

    //获取所有通过审核的信息
    List<Message> getAllPassedMessage();

    //获取所有待审核的信息
    List<Message> getAllNeedCheckMessage();

    //获取所有待修改审核的信息
    List<Message> getAllNeedModifyMessage();

    //根据messageId
    Message getMessageById(int messageId);

    //按用户id查找启事信息
    List<Message> getMessageByUserId(String userId);

    //获取满足限制的启事信息
    List<Message> getMessageUnderConstrain(Date date, List<String> noticeType, List<String> objectType, String keyword);

    Message getMaxMessageId();
}
