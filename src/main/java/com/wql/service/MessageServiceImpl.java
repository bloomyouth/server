package com.wql.service;

import com.wql.dao.MessageMapper;
import com.wql.pojo.Message;
import com.wql.util.SystemConstant;

import java.util.Date;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    private MessageMapper messageMapper;
    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public String addMessage(Message message) {
        this.messageMapper.addMessage(message);
        return SystemConstant.SUCCESS;
    }

    @Override
    public String modifyMessage(Message message) {
        if(this.messageMapper.getMessageById(message.getMessageId())==null){
            return "错误，该启事不存在";
        }
        else {
            this.messageMapper.modifyMessage(message);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public String deleteMessage(int messageId) {
        if(this.messageMapper.getMessageById(messageId)==null){
            return "错误，该启事不存在";
        }
        else {
            this.messageMapper.deleteMessage(messageId);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public List<Message> getMessageByUserId(String userId) {
        return messageMapper.getMessageByUserId(userId);
    }

    @Override
    public String acceptMessageByUserId(int messageId) {
        if(this.messageMapper.getMessageById(messageId)==null){
            return "错误，该启事不存在";
        }
        else {
            this.messageMapper.acceptMessageById(messageId);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public String rejectMessageByUserId(int messageId) {
        if(this.messageMapper.getMessageById(messageId)==null){
            return "错误，该启事不存在";
        }
        else {
            this.messageMapper.rejectMessageById(messageId);
            return SystemConstant.SUCCESS;
        }
    }

    @Override
    public List<Message> getAllPassedMessage() {
        return messageMapper.getAllPassedMessage();
    }

    @Override
    public Message getMaxMessageId() {
        if(this.messageMapper.getMaxMessageId()==null);
        return this.messageMapper.getMaxMessageId();
    }

    @Override
    public Message getMessageByMessageId(int messageId){return messageMapper.getMessageById(messageId);}
}
