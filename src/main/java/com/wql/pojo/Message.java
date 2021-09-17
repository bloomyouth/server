package com.wql.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Message {
    private int messageId;//启事序号
    private String messageType;//启事类型
    private String objectName;//物品名称
    private String objectType;//物品类型
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String messageDate;//发布日期
    private String messageState;//启事状态
    private String description;//具体描述
    private String userId;//发布人

    public Message() {

    }

    public Message(int messageId, String messageType, String objectName, String objectType, String messageDate, String messageState, String description, String userId) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.objectName = objectName;
        this.objectType = objectType;
        this.messageDate = messageDate;
        this.messageState = messageState;
        this.description = description;
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String  messageTime) {
        this.messageDate = messageTime;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
