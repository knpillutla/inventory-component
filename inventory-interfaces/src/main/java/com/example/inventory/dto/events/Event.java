package com.example.inventory.dto.events;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Event {
	public String eventName = "Event";
	public String errorMsg = "";
	public Map<String, Object> headerMap = new HashMap();
	public Object requestObj;
	public Object errorObj;
	
	public Event(){};
	
	public Event(String name) {
		eventName = name;
	}
	public Event(String name, Object requestObj) {
		eventName = name;
		this.requestObj = requestObj;
	}
	public Event(String name, Object requestObj, Object errorObj, String errorMsg) {
		eventName = name;
		this.requestObj = requestObj;
		this.errorObj = errorObj;
	}	
	public void addHeader(String key, Object value) {
		headerMap.put(key, value);
	}

}
