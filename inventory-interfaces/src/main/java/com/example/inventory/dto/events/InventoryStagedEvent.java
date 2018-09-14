package com.example.inventory.dto.events;

import com.example.inventory.dto.responses.InventoryDTO;

import lombok.Data;

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
