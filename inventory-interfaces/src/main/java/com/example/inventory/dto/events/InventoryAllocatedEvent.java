package com.example.inventory.dto.events;

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
public class InventoryAllocatedEvent extends BaseEvent{
	private static String EVENT_NAME = "InventoryAllocatedEvent";
	InventoryDTO inventoryDTO;
	
	public InventoryAllocatedEvent(InventoryDTO inventoryDTO) {
		super(EVENT_NAME);
		this.inventoryDTO = inventoryDTO;
		this.addHeader("eventName", this.getEventName());
		this.addHeader("busName", this.inventoryDTO.getBusName());
		this.addHeader("locnNbr",this.inventoryDTO.getLocnNbr());
		this.addHeader("orderNbr",this.inventoryDTO.getOrderNbr());
		this.addHeader("busUnit", this.inventoryDTO.getBusUnit());
		this.addHeader("itemBrcd", this.inventoryDTO.getItemBrcd());
	}	
}
