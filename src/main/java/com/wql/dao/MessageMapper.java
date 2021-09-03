package com.wql.dao;

import com.wql.pojo.Messages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {

    int addMessage(Messages message);

    int deleteMessageById(int id);

    int updateMessage(Messages message);

    Messages queryMessageById(int id);

    List<Messages> queryAllMessage();


}
