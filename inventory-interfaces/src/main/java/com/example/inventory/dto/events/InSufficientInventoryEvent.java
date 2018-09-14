package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.example.inventory.dto.responses.InventoryDTO;

import lombok.Data;

@Data
public class InSufficientInventoryEvent extends Event{
	public InSufficientInventoryEvent(List<InventoryReservationRequestDTO>invnResvReqList, InventoryReservationRequestDTO failedReq, String errorMsg) {
		super("InSufficientInventoryEvent", invnResvReqList, failedReq, errorMsg);
	}
}
