package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class InventoryReservationFailedEvent extends ExceptionEvent{
	private static String EVENT_NAME = "InventoryReservationFailedEvent";
	List<InventoryReservationRequestDTO>invnResvReqList;
	InventoryReservationRequestDTO failedReq;
	
	public InventoryReservationFailedEvent(List<InventoryReservationRequestDTO>invnResvReqList, InventoryReservationRequestDTO failedReq, String errorMsg) {
		super(EVENT_NAME, errorMsg);
		invnResvReqList = invnResvReqList;
		failedReq = failedReq;
	}
}
