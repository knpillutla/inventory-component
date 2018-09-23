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
public class InventoryAllocatedEvent extends BaseEvent{
	private static String EVENT_NAME = "InventoryAllocatedEvent";
	Long orderLineId;
	Long orderId;
	String orderNbr;
	String busName;
	Integer locnNbr;
	String busUnit;
	String itemBrcd;
	Integer qty;
	
	List<InventoryDTO> inventoryDTOList;
	
	public InventoryAllocatedEvent(Long orderLineId, Long orderId,String orderNbr, String busName, Integer locnNbr,
			String busUnit, String itemBrcd, Integer qty, List<InventoryDTO> inventoryDTOList) {
		super(EVENT_NAME);
		this.orderLineId = orderLineId;
		this.orderId = orderId;
		this.orderNbr = orderNbr;
		this.busName = busName;
		this.locnNbr = locnNbr;
		this.busUnit = busUnit;
		this.itemBrcd = itemBrcd;
		this.qty = qty;
		this.inventoryDTOList = inventoryDTOList;
		this.addHeader("eventName", this.getEventName());
		this.addHeader("busName", this.getBusName());
		this.addHeader("locnNbr",this.getLocnNbr());
		this.addHeader("orderNbr",this.getOrderNbr());
		this.addHeader("busUnit", this.getBusUnit());
		this.addHeader("itemBrcd", this.getItemBrcd());
	}	
}
