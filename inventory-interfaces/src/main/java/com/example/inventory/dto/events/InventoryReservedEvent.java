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
public class InventoryReservedEvent{
	List<InventoryDTO> inventoryDTOList;
	
	public InventoryReservedEvent(List<InventoryDTO> inventoryDTOList) {
		this.inventoryDTOList = inventoryDTOList;
	}	
}
