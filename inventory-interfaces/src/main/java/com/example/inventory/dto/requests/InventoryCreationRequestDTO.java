package com.example.inventory.dto.requests;

import com.example.inventory.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class InventoryCreationRequestDTO extends BaseDTO{
	public String busName;
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

	public InventoryCreationRequestDTO(String busName, Integer locnNbr, String busUnit, String company,
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
