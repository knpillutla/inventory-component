package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryCreationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class InventoryCreationFailedEvent extends ExceptionEvent{
	private static String EVENT_NAME = "InventoryCreationFailedEvent";
	InventoryCreationRequestDTO inventoryCreationRequestDTO;
	
	public InventoryCreationFailedEvent(InventoryCreationRequestDTO inventoryCreationRequestDTO, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		inventoryCreationRequestDTO = inventoryCreationRequestDTO;
	}
}
