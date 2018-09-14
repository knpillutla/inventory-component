package com.example.inventory.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.inventory.db.Inventory;
import com.example.inventory.dto.requests.InventoryReservationRequestDTO;
import com.example.inventory.exception.InsufficientInventoryException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceByItem extends InventoryServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceByItem.class);

	@Override
	public List<Inventory> getInventory(InventoryReservationRequestDTO invnResvRequest) throws InsufficientInventoryException{
		List<Inventory> invnEntityList = null;
		invnEntityList = inventoryDAO.findByItemBrcd(invnResvRequest.getLocnNbr(), invnResvRequest.getIlpn(), InventoryStatus.AVAILABLE.getStatCode());
		int totalQtyReserved = 0;
		int qtyToBeReserved = invnResvRequest.getQty();
		for(Inventory invn : invnEntityList) {
			int qtyReserved = 0;
			if(invn.getQty()-qtyToBeReserved<=0) {
				invn.setStatCode(InventoryStatus.RESERVED.getStatCode());
				//Inventory savedInvnEntity = inventoryDAO.save(invn);
				invnEntityList.add(invn);
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
				newInventory.setUpdatedBy(invnResvRequest.getUserId());
				Date creationDate = new Date();
				newInventory.setCreatedDttm(creationDate);
				newInventory.setUpdatedDttm(creationDate);
				newInventory.setStatCode(InventoryStatus.RESERVED.getStatCode());
				//Inventory savedInventoryObj = inventoryDAO.save(newInventory);
				invnEntityList.add(newInventory);
						
				// update available qty for the current locn/item
				invn.setQty(invn.getQty()-qtyReserved);
				inventoryDAO.save(invn);
				//Inventory updatedInvnEntity = inventoryDAO.save(invn);
				invnEntityList.add(invn);
				break;
			}
			totalQtyReserved = totalQtyReserved + qtyReserved;
			qtyToBeReserved = qtyToBeReserved - qtyReserved;
		}
		
		// there is not enough quantity availabile in Active to reserve, throw exception or trigger replenishment
		if(qtyToBeReserved>0){
			throw new InsufficientInventoryException("Not Enough Quantity To Reserve for Item:" + invnResvRequest.toString());
		}
		return invnEntityList;
	}
}
