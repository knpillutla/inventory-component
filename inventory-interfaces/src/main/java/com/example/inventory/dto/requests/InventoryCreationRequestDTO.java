package com.example.inventory.dto.requests;

import com.example.inventory.dto.BaseDTO;

import lombok.Data;

@Data
public class InventoryCreationRequestDTO extends BaseDTO{
	public Integer busName;
	public Integer locnNbr;
	public String busUnit;
	public String company;
	public String division;
	public String locnBrcd;
	public String itemBrcd;
	public Integer qty;
	public String ilpn;
	public boolean trackByLPN;
	public String userId;

	public InventoryCreationRequestDTO() {}
	
	public InventoryCreationRequestDTO(Integer busName, Integer locnNbr, String busUnit, String company,
			String division, String locnBrcd, String itemBrcd, Integer qty, String ilpn, boolean trackByLPN,
			String userId) {
		super();
		this.busName = busName;
		this.locnNbr = locnNbr;
		this.busUnit = busUnit;
		this.company = company;
		this.division = division;
		this.locnBrcd = locnBrcd;
		this.itemBrcd = itemBrcd;
		this.qty = qty;
		this.ilpn = ilpn;
		this.trackByLPN = trackByLPN;
		this.userId = userId;
	}

}
