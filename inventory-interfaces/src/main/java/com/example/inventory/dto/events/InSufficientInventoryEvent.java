package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class InSufficientInventoryEvent extends BaseEvent{
	public InSufficientInventoryEvent(List<InventoryReservationRequestDTO>invnResvReqList, InventoryReservationRequestDTO failedReq, String errorMsg) {
		super("InSufficientInventoryEvent", invnResvReqList, failedReq, errorMsg);
	}
}
