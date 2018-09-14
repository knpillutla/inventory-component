package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.example.inventory.dto.responses.InventoryDTO;

import lombok.Data;

@Data
public class InventoryReservedEvent{
	List<InventoryDTO> inventoryDTOList;
	
	public InventoryReservedEvent(List<InventoryDTO> inventoryDTOList) {
		this.inventoryDTOList = inventoryDTOList;
	}	
}
