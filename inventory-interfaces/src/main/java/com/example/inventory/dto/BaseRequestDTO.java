package com.example.inventory.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class BaseRequestDTO {
	public Map<String, Object> headerMap = new HashMap();
	
	public void addHeader(String key, Object value) {
		headerMap.put(key, value);	
	}
}
