package com.wql.service;

import com.wql.dao.MessageMapper;
import com.wql.pojo.Messages;

import java.util.List;


public class MessageServiceImpl implements MessageService {

    private MessageMapper messageMapper;

    public void setMessageMapper(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    public int addMessage(Messages message){
        return messageMapper.addMessage(message);
    }

    public int deleteMessageById(int id){
        return messageMapper.deleteMessageById(id);
    }

    public int updateMessage(Messages book){
        return messageMapper.updateMessage(book);
    }

    public Messages queryMessageById(int id){
        return messageMapper.queryMessageById(id);
    }

    public List<Messages> queryAllMessage(){
        return messageMapper.queryAllMessage();
    }

}
