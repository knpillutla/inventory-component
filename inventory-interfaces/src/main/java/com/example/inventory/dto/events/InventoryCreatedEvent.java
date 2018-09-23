package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.responses.InventoryDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class InventoryCreatedEvent extends BaseEvent{
	private static String EVENT_NAME = "InventoryCreatedEvent";
	public InventoryDTO inventoryDTO;
	
	public InventoryCreatedEvent(InventoryDTO inventoryDTO) {
		super(EVENT_NAME);
		this.inventoryDTO = inventoryDTO;
		this.addHeader("eventName", this.getEventName());
		this.addHeader("busName", inventoryDTO.getBusName());
		this.addHeader("locnNbr",inventoryDTO.getLocnNbr());
		this.addHeader("locnBrcd",inventoryDTO.getLocnBrcd());
		this.addHeader("busUnit", inventoryDTO.getBusUnit());
		this.addHeader("itemBrcd", inventoryDTO.getItemBrcd());
	}	
}
