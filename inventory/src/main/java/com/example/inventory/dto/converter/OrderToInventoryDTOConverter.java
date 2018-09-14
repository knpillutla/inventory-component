package com.example.inventory.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.integration.dto.event.OrderCreatedEvent;
import com.example.integration.dto.response.OrderDTO;
import com.example.integration.dto.response.OrderLineDTO;
import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderToInventoryDTOConverter {
	
	public List<InventoryReservationRequestDTO> createInvResvReq(OrderCreatedEvent orderCreatedEvent) {
		ObjectMapper mapper = new ObjectMapper();
		OrderDTO orderDTO = mapper.convertValue(orderCreatedEvent.getRequestObj(), OrderDTO.class);
		List<InventoryReservationRequestDTO> invnResvReqList = new ArrayList();
		for(OrderLineDTO orderLineDTO : orderDTO.getOrderLines()) {
			InventoryReservationRequestDTO invResvReqDTO = new InventoryReservationRequestDTO();
			invResvReqDTO.setLocnNbr(orderDTO.getLocnNbr());
			invResvReqDTO.setBusUnit(orderDTO.getBusUnit());
			invResvReqDTO.setItemBrcd(orderLineDTO.getItemBrcd());
//			invResvReqDTO.setIlpn(orderLineDTO.get.getIlpn());
//			invResvReqDTO.setTrackByLPN(orderDTO.isTrackByLPN()?"Y":"N");
			invResvReqDTO.setQty(orderLineDTO.getOrderQty());
			invResvReqDTO.setUserId(orderDTO.getUpdatedBy());
			invnResvReqList.add(invResvReqDTO);
		}
		return invnResvReqList;
	}
}
