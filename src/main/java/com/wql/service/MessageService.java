package com.wql.service;

import com.wql.pojo.Message;

import java.util.Date;
import java.util.List;

public interface MessageService {

    String addMessage(Message message);

    String modifyMessage(Message message);

    String deleteMessage(int messageId);

    List<Message> getAllMessage();

    List<Message> getMessageByUserId(String userId);

    String acceptMessageByUserId(int messageId);

    String rejectMessageByUserId(int messageId);

    List<Message> getAllPassedMessage();

    Message getMaxMessageId();

    Message getMessageByMessageId(int messageId);
}
