package com.wql.service;

import com.wql.pojo.Messages;

import java.util.List;


public interface MessageService {
    int addMessage(Messages message);

    int deleteMessageById(int id);

    int updateMessage(Messages message);

    Messages queryMessageById(int id);

    List<Messages> queryAllMessage();
}
