package com.example.inventory.dto.requests;

import com.example.inventory.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class InventoryReservationRequestDTO  extends BaseDTO{
	public Integer busName;
	public Integer locnNbr;
	public String busUnit;
	public String company;
	public String division;
	private String locnBrcd;
	private String itemBrcd;
	private String ilpn;
	private Integer qty;
	private String batchNbr;
	private String orderNbr;
	private String packageNbr;
	private String userId;

	public InventoryReservationRequestDTO(Integer busName, Integer locnNbr, String busUnit, String company,
			String division, String locnBrcd, String itemBrcd, String ilpn, Integer qty, String batchNbr,
			String orderNbr, String packageNbr, String userId) {
		super();
		this.busName = busName;
		this.locnNbr = locnNbr;
		this.busUnit = busUnit;
		this.company = company;
		this.division = division;
		this.locnBrcd = locnBrcd;
		this.itemBrcd = itemBrcd;
		this.ilpn = ilpn;
		this.qty = qty;
		this.batchNbr = batchNbr;
		this.orderNbr = orderNbr;
		this.packageNbr = packageNbr;
		this.userId = userId;
	}
}
