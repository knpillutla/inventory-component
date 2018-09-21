package com.example.inventory.endpoint.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import com.example.inventory.dto.converter.OrderToInventoryDTOConverter;
import com.example.inventory.dto.requests.InventoryCreationRequestDTO;
import com.example.inventory.service.InventoryService;
import com.example.inventory.streams.InventoryStreams;
import com.example.order.dto.events.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InventoryListener {
	@Autowired
	InventoryService inventoryService;

	@Autowired
	OrderToInventoryDTOConverter orderToInvnConvertor;
	
	@StreamListener(InventoryStreams.ORDERS_OUTPUT)
	public void handleIncomingOrders(OrderCreatedEvent orderCreatedEvent) {
		log.info("Inventory Service, Received Msg: {}" + ": at :" + new java.util.Date(), orderCreatedEvent.toString());
		long startTime = System.currentTimeMillis();
		try {
			inventoryService.reserveInventory(orderToInvnConvertor.createInvResvReq(orderCreatedEvent));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error occured while processing Incoming orders :" + e.getMessage(), e);
		}
		long endTime = System.currentTimeMillis();
		log.info("Completed Inventory Creation for Order for : " + orderCreatedEvent + ": at :" + new java.util.Date()
				+ " : total time:" + (endTime - startTime) / 1000.00 + " secs");
	}

	@StreamListener(InventoryStreams.INVENTORY_INPUT)
	public void handleNewInventory(InventoryCreationRequestDTO inventoryCreationReqDTO) {
		log.info("Inventory Service, Received Msg: {}" + ": at :" + new java.util.Date(), inventoryCreationReqDTO.toString());
		long startTime = System.currentTimeMillis();
		try {
			List newInvnList = new ArrayList();
			newInvnList.add(inventoryCreationReqDTO);
			inventoryService.createInventory(newInvnList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error occured while processing Incoming Inventory :" + e.getMessage(), e);
		}
		long endTime = System.currentTimeMillis();
		log.info("Completed Inventory Creation for Order for : " + inventoryCreationReqDTO + ": at :" + new java.util.Date()
				+ " : total time:" + (endTime - startTime) / 1000.00 + " secs");
	}

}
