package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryCreationRequestDTO;

import lombok.Data;

@Data
public class InventoryCreationFailedEvent extends BaseEvent{
	public InventoryCreationFailedEvent(List<InventoryCreationRequestDTO>invnResvReqList, InventoryCreationRequestDTO failedReq, String errorMsg) {
		super("InventoryCreationFailedEvent", invnResvReqList, failedReq, errorMsg);
	}
}
