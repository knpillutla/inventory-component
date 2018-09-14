package com.example.inventory.service;

import java.io.IOException;
import java.util.List;

import com.example.inventory.dto.requests.InventoryCreationRequestDTO;
import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.example.inventory.dto.responses.InventoryDTO;

public interface InventoryService {
	InventoryDTO findById(Integer locnNbr, Long pickId) throws Exception;
	List<InventoryDTO> createInventory(List<InventoryCreationRequestDTO> invnCreationReq) throws Exception;
	List<InventoryDTO> reserveInventory(List<InventoryReservationRequestDTO> invnResvRequestList) throws Exception;
}