package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.responses.InventoryDTO;

import lombok.Data;

@Data
public class InventoryCreatedEvent extends Event{
	public List<InventoryDTO> inventoryDTOList;
	public InventoryCreatedEvent(List<InventoryDTO> inventoryDTOList) {
		super("InventoryAvailableEvent");
		this.inventoryDTOList = inventoryDTOList;
		if(inventoryDTOList.size()>0) {
			this.addHeader("locnNbr",inventoryDTOList.get(0).getLocnNbr());
			this.addHeader("locnBrcd",inventoryDTOList.get(0).getLocnBrcd());
			this.addHeader("busUnit", inventoryDTOList.get(0).getBusUnit());
			this.addHeader("itemBrcd", inventoryDTOList.get(0).getItemBrcd());
		}
	}	
}
