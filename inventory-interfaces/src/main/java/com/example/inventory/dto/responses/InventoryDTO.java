package com.example.inventory.dto.responses;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
public class InventoryDTO  implements Serializable{
	Long id;
	Integer locnNbr;
	String busUnit;
	String locnBrcd;
	String itemBrcd;
	Integer qty;
	Integer statCode;
	String ilpn;
	String waveNbr;
	String orderNbr;
	String packageNbr;
	String transitContainerNbr;
	String source;
	String transactionName;
	String trackByLPN;
	String refField1;
	String refField2;
	Date updatedDttm;
	String updatedBy;
	
	public InventoryDTO(Long id, Integer locnNbr, String busUnit, String locnBrcd, String itemBrcd, Integer qty,
			Integer statCode, String ilpn, String waveNbr, String orderNbr, String packageNbr,
			String transitContainerNbr, String source, String transactionName, String trackByLPN, String refField1,
			String refField2, Date updatedDttm, String updatedBy) {
		super();
		this.id = id;
		this.locnNbr = locnNbr;
		this.busUnit = busUnit;
		this.locnBrcd = locnBrcd;
		this.itemBrcd = itemBrcd;
		this.qty = qty;
		this.statCode = statCode;
		this.ilpn = ilpn;
		this.waveNbr = waveNbr;
		this.orderNbr = orderNbr;
		this.packageNbr = packageNbr;
		this.transitContainerNbr = transitContainerNbr;
		this.source = source;
		this.transactionName = transactionName;
		this.trackByLPN = trackByLPN;
		this.refField1 = refField1;
		this.refField2 = refField2;
		this.updatedDttm = updatedDttm;
		this.updatedBy = updatedBy;
	}
}
