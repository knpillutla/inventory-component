package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryReservationRequestDTO;

import lombok.Data;

@Data
public class InventoryReservationFailedEvent extends BaseEvent{
	public InventoryReservationFailedEvent(List<InventoryReservationRequestDTO> invnResvReqList, InventoryReservationRequestDTO failedReq, String errorMsg) {
		super("InventoryReservationFailedEvent", invnResvReqList, failedReq, errorMsg);
	}

}
