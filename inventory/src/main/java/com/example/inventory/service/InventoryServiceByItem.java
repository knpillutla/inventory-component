package com.example.inventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.inventory.db.Inventory;
import com.example.inventory.dto.requests.InventoryAllocationRequestDTO;
import com.example.inventory.exception.InsufficientInventoryException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceByItem extends InventoryServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceByItem.class);

	@Override
	public List<Inventory> getInventoryToBeAllocated(InventoryAllocationRequestDTO invnAllocationRequest) throws InsufficientInventoryException{
		List<Inventory> invnEntityList = null;
		invnEntityList = inventoryDAO.findByBusNameAndLocnNbrAndItemBrcd(invnAllocationRequest.getBusName(), invnAllocationRequest.getLocnNbr(), invnAllocationRequest.getItemBrcd(), InventoryStatus.AVAILABLE.getStatCode());
		int totalQtyReserved = 0;
		int qtyToBeReserved = invnAllocationRequest.getQty();
		List<Inventory> reservedEntityList = new ArrayList();
		if(invnEntityList == null)
			return reservedEntityList;
		for(Inventory invn : invnEntityList) {
			int qtyReserved = 0;
			if(invn.getQty()-qtyToBeReserved<=0) {
				invn.setStatCode(InventoryStatus.ALLOCATED.getStatCode());
				//Inventory savedInvnEntity = inventoryDAO.save(invn);
				reservedEntityList.add(invn);
				qtyReserved =  invn.getQty();
			}else {
				qtyReserved = qtyToBeReserved;
				// create new inventory record for the reserved inventory
				Inventory newInventory = new Inventory();
				newInventory.setLocnNbr(invn.getLocnNbr());
				newInventory.setBusUnit(invn.getBusUnit());
				newInventory.setLocnBrcd(invn.getLocnBrcd());
				newInventory.setItemBrcd(invn.getItemBrcd());
				newInventory.setTrackByLPN("N");
				newInventory.setQty(qtyReserved);
				newInventory.setBatchNbr(invn.getBatchNbr());
				newInventory.setOrderNbr(invn.getOrderNbr());
				newInventory.setOlpn(invn.getOlpn());
				newInventory.setCreatedBy(invn.getCreatedBy());
				newInventory.setUpdatedBy(invnAllocationRequest.getUserId());
				Date creationDate = new Date();
				newInventory.setCreatedDttm(creationDate);
				newInventory.setUpdatedDttm(creationDate);
				newInventory.setStatCode(InventoryStatus.ALLOCATED.getStatCode());
				//Inventory savedInventoryObj = inventoryDAO.save(newInventory);
				reservedEntityList.add(newInventory);
						
				// update available qty for the current locn/item
				invn.setQty(invn.getQty()-qtyReserved);
				//inventoryDAO.save(invn);
				//Inventory updatedInvnEntity = inventoryDAO.save(invn);
				reservedEntityList.add(invn);
				break;
			}
			totalQtyReserved = totalQtyReserved + qtyReserved;
			qtyToBeReserved = qtyToBeReserved - qtyReserved;
		}
		
		// there is not enough quantity availabile in Active to reserve, throw exception or trigger replenishment
		if(qtyToBeReserved>0){
			throw new InsufficientInventoryException("Not Enough Quantity To Reserve for Item:" + invnAllocationRequest.toString());
		}
		return reservedEntityList;
	}
}
