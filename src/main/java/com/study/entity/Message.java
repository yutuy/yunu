package com.study.entity;

import java.util.List;
import java.util.Map;

public class Message {
	
	private String name;
	
	private Integer num;
	
	private Integer num2;
	
    private String messageCode;

    private String messageStatus;

    private String cause;
    
    private List<Map<String, Object>> list;

    public Message(String messageCode, String messageStatus, String cause,String name,Integer num,Integer num2,List list) {
        this.messageCode = messageCode;
        this.messageStatus = messageStatus;
        this.cause = cause;
        this.name = name;
        this.num = num;
        this.num2 = num2;
        this.list = list;
    }

    public Message() {
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum2() {
		return num2;
	}

	public void setNum2(Integer num2) {
		this.num2 = num2;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
}