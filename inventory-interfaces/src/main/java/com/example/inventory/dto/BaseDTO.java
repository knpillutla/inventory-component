package com.example.inventory.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.inventory.dto.events.InventoryCreatedEvent;
import com.example.inventory.dto.responses.InventoryDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@NoArgsConstructor
public class BaseDTO  implements Serializable{
	public Map<String, Object> headerMap = new HashMap();
	
	public void addHeader(String key, Object value) {
		headerMap.put(key, value);	
	}
}
