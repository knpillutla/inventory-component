package com.example.inventory.dto.events;

import java.util.List;

import com.example.inventory.dto.requests.InventoryCreationRequestDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class InventoryCreationFailedEvent extends BaseEvent{
	public InventoryCreationFailedEvent(List<InventoryCreationRequestDTO>invnResvReqList, InventoryCreationRequestDTO failedReq, String errorMsg) {
		super("InventoryCreationFailedEvent", invnResvReqList, failedReq, errorMsg);
	}
}
