package com.example.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.db.Inventory;
import com.example.inventory.db.InventoryRepository;
import com.example.inventory.dto.converter.InventoryDTOConverter;
import com.example.inventory.dto.events.InSufficientInventoryEvent;
import com.example.inventory.dto.events.InventoryCreatedEvent;
import com.example.inventory.dto.events.InventoryCreationFailedEvent;
import com.example.inventory.dto.events.InventoryReservationFailedEvent;
import com.example.inventory.dto.events.InventoryStagedEvent;
import com.example.inventory.dto.requests.InventoryCreationRequestDTO;
import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.example.inventory.dto.responses.InventoryDTO;
import com.example.inventory.exception.InsufficientInventoryException;
import com.example.inventory.exception.InventoryException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public abstract class InventoryServiceImpl implements InventoryService {
	@Autowired
	InventoryRepository inventoryDAO;

	@Autowired
	EventPublisher eventPublisher;

	@Autowired
	InventoryDTOConverter inventoryDTOConverter;

	public enum InventoryStatus {
		STAGED(100), AVAILABLE(110), RESERVED(120), PICKED(130), PACKED(140), CYCLECOUNT(150), SHIPPED(160);
		InventoryStatus(Integer statCode) {
			this.statCode = statCode;
		}

		private Integer statCode;

		public Integer getStatCode() {
			return statCode;
		}
	}

	@Override
	public List<InventoryDTO> reserveInventory(List<InventoryReservationRequestDTO> invnResvRequestList)
			throws InventoryException {
		List<InventoryDTO> invnDTOList = new ArrayList();
		for (InventoryReservationRequestDTO invnResvRequest : invnResvRequestList) {
			try {
				invnDTOList.addAll(this.reserveInventory(invnResvRequest));
			} catch (InventoryException ex) {
				InSufficientInventoryEvent event = new InSufficientInventoryEvent(invnResvRequestList, invnResvRequest,
						"Insufficient Inventory Reservation Error:" + ex.getMessage());
				InventoryException invException = new InventoryException(event);
				eventPublisher.publish(event);
				throw invException;
			} catch (Exception ex) {
				InventoryReservationFailedEvent event = new InventoryReservationFailedEvent(invnResvRequestList,
						invnResvRequest, "Inventory Reservation Error:" + ex.getMessage());
				InventoryException invException = new InventoryException(event);
				eventPublisher.publish(event);
				throw invException;
			}
		}
		return invnDTOList;
	}

	public List<InventoryDTO> reserveInventory(InventoryReservationRequestDTO invnResvRequest)
			throws Exception {

		List<InventoryDTO> invnDTOList = new ArrayList();
		List<Inventory> invnList = this.getInventory(invnResvRequest);
		for (Inventory invn : invnList) {
			invnDTOList.add(inventoryDTOConverter.getInventoryDTO(inventoryDAO.save(invn)));
		}
		return invnDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public abstract List<Inventory> getInventory(InventoryReservationRequestDTO invnResvRequest) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 */
	@Override
	@Transactional
	public List<InventoryDTO> createInventory(List<InventoryCreationRequestDTO> invnCreationReqList)
			throws InventoryException {
		List<InventoryDTO> inventoryDTOList = new ArrayList();
		for (InventoryCreationRequestDTO invnCreationReq : invnCreationReqList) {
			try {
				InventoryDTO inventoryDTO = this.createInventory(invnCreationReq, false);
				inventoryDTOList.add(inventoryDTO);
			} catch (Exception ex) {
				log.error("Inventory Creation Error:" + ex.getMessage(), ex);
				InventoryCreationFailedEvent event = new InventoryCreationFailedEvent(invnCreationReqList,
						invnCreationReq, "Inventory Creation Error:" + ex.getMessage());
				InventoryException invException = new InventoryException(event);
				eventPublisher.publish(event);
				throw invException;

			}
			eventPublisher.publish(new InventoryCreatedEvent(inventoryDTOList));
		}
		return inventoryDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	private InventoryDTO createInventory(InventoryCreationRequestDTO invnCreationReq, boolean stage)
			throws InventoryException {
		InventoryDTO inventoryDTO = null;
		Inventory newInventory = inventoryDTOConverter.getInventoryEntity(invnCreationReq);
		newInventory
				.setStatCode(stage ? InventoryStatus.STAGED.getStatCode() : InventoryStatus.AVAILABLE.getStatCode());
		Inventory savedInventoryObj = inventoryDAO.save(newInventory);
		inventoryDTO = inventoryDTOConverter.getInventoryDTO(savedInventoryObj);
		return inventoryDTO;
	}

	@Override
	public InventoryDTO findById(Integer locnNbr, Long id) throws Exception {
		Inventory invnEntity = inventoryDAO.findById(locnNbr, (long) id);
		return inventoryDTOConverter.getInventoryDTO(invnEntity);
	}

}
