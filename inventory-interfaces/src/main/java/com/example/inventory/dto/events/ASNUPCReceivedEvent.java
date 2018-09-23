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
public class ASNUPCReceivedEvent extends BaseEvent{
	private static String EVENT_NAME = "ASNUPCReceivedEvent";
	String busName;
	Integer locnNbr;
	String busUnit;
	String itemBrcd;
	Integer qty;
	
	public ASNUPCReceivedEvent(String busName, Integer locnNbr,
			String busUnit, String itemBrcd, Integer qty) {
		super(EVENT_NAME);
		this.busName = busName;
		this.locnNbr = locnNbr;
		this.busUnit = busUnit;
		this.itemBrcd = itemBrcd;
		this.qty = qty;
		this.addHeader("eventName", this.getEventName());
		this.addHeader("busName", this.getBusName());
		this.addHeader("locnNbr",this.getLocnNbr());
		this.addHeader("busUnit", this.getBusUnit());
		this.addHeader("itemBrcd", this.getItemBrcd());
	}	
}
