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
public class InventoryStagedEvent extends BaseEvent{
	public InventoryDTO inventoryDTO;
	
	public InventoryStagedEvent(InventoryDTO inventoryDTO) {
		super("InventoryStagedEvent");
		this.inventoryDTO = inventoryDTO;
		this.addHeader("locnNbr",inventoryDTO.getLocnNbr());
		this.addHeader("locnBrcd",inventoryDTO.getLocnBrcd());
		this.addHeader("busUnit", inventoryDTO.getBusUnit());
		this.addHeader("itemBrcd", inventoryDTO.getItemBrcd());
	}
}
