package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 日志实体类
 * @Author Administrator
 * @Time 2018/7/9 21:03
 */
public class Log implements Serializable {

    private String logId;
    private String logUser;
    private String logTime;
    private String logResource;
    private String logAction;
    private String logMessage;
    private String logResult;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    public Log(String logId, String logUser, String logTime, String logResource, String logAction, String logMessage, String logResult) {
        this.logId = logId;
        this.logUser = logUser;
        this.logTime = logTime;
        this.logResource = logResource;
        this.logAction = logAction;
        this.logMessage = logMessage;
        this.logResult = logResult;
    }

    public Log() {
        super();
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime='" + logTime + '\'' +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}
