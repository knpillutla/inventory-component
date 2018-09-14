package com.example.inventory.dto.events;

import java.util.HashMap;
import java.util.Map;

import com.example.inventory.dto.BaseDTO;

import lombok.Data;

@Data
public class BaseEvent extends BaseDTO{
	public String eventName = "Event";
	public String errorMsg = "";
	public Object requestObj;
	public Object errorObj;
	
	public BaseEvent(){};
	
	public BaseEvent(String name) {
		eventName = name;
	}
	public BaseEvent(String name, Object requestObj) {
		eventName = name;
		this.requestObj = requestObj;
	}
	public BaseEvent(String name, Object requestObj, Object errorObj, String errorMsg) {
		eventName = name;
		this.requestObj = requestObj;
		this.errorObj = errorObj;
	}	
}
