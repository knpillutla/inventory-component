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
	private static String EVENT_NAME = "InSufficientInventoryEvent";
	public List<InventoryDTO> inventoryDTOList;
	
	public InventoryCreatedEvent(List<InventoryDTO> inventoryDTOList) {
		super(EVENT_NAME);
		this.inventoryDTOList = inventoryDTOList;
		if(inventoryDTOList.size()>0) {
			this.addHeader("locnNbr",inventoryDTOList.get(0).getLocnNbr());
			this.addHeader("locnBrcd",inventoryDTOList.get(0).getLocnBrcd());
			this.addHeader("busUnit", inventoryDTOList.get(0).getBusUnit());
			this.addHeader("itemBrcd", inventoryDTOList.get(0).getItemBrcd());
		}
	}	
}
