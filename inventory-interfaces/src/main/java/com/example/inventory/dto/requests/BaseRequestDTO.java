package com.example.inventory.dto.requests;

import java.util.HashMap;
import java.util.Map;

import com.example.inventory.dto.BaseDTO;

import lombok.Data;

@Data
public class BaseRequestDTO extends BaseDTO{
	public String eventName = "Event";
	public String errorMsg = "";
	public Object requestObj;
	public Object errorObj;
	
	public BaseRequestDTO(){};
	
	public BaseRequestDTO(String name) {
		eventName = name;
	}
	public BaseRequestDTO(String name, Object requestObj) {
		eventName = name;
		this.requestObj = requestObj;
	}
	public BaseRequestDTO(String name, Object requestObj, Object errorObj, String errorMsg) {
		eventName = name;
		this.requestObj = requestObj;
		this.errorObj = errorObj;
	}	
}
