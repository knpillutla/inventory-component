package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.responses.InventoryDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class InventoryCreatedEvent extends BaseEvent{
	private static final long serialVersionUID = 1L;
	public List<InventoryDTO> inventoryDTOList;
	
	public InventoryCreatedEvent(List<InventoryDTO> inventoryDTOList) {
		super("InventoryCreatedEvent");
		this.inventoryDTOList = inventoryDTOList;
		if(inventoryDTOList.size()>0) {
			this.addHeader("locnNbr",inventoryDTOList.get(0).getLocnNbr());
			this.addHeader("locnBrcd",inventoryDTOList.get(0).getLocnBrcd());
			this.addHeader("busUnit", inventoryDTOList.get(0).getBusUnit());
			this.addHeader("itemBrcd", inventoryDTOList.get(0).getItemBrcd());
		}
	}	
}
