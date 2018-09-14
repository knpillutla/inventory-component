package com.example.integration.dto.response;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OrderLineDTO  implements Serializable{
	Long id;
	Integer locnNbr;
	Integer orderId;
	String itemBrcd;
	Integer origOrderQty;
	Integer orderQty;
	Integer cancelledQty;
	Integer shortQty;
	Integer pickedQty;
	Integer packedQty;
	Integer shippedQty;
	Integer statCode;
	String olpn;
	String source;
	String transactionName;
	String refField1;
	String refField2;
	Date updatedDttm;
	String updatedBy;

	public OrderLineDTO(Long id, Integer locnNbr, Integer orderId, String itemBrcd, Integer origOrderQty,
			Integer orderQty, Integer cancelledQty, Integer shortQty, Integer pickedQty, Integer packedQty,
			Integer shippedQty, Integer statCode, String olpn, String source, String transactionName, String refField1,
			String refField2, Date updatedDttm, String updatedBy) {
		super();
		this.id = id;
		this.locnNbr = locnNbr;
		this.orderId = orderId;
		this.itemBrcd = itemBrcd;
		this.origOrderQty = origOrderQty;
		this.orderQty = orderQty;
		this.cancelledQty = cancelledQty;
		this.shortQty = shortQty;
		this.pickedQty = pickedQty;
		this.packedQty = packedQty;
		this.shippedQty = shippedQty;
		this.statCode = statCode;
		this.olpn = olpn;
		this.source = source;
		this.transactionName = transactionName;
		this.refField1 = refField1;
		this.refField2 = refField2;
		this.updatedDttm = updatedDttm;
		this.updatedBy = updatedBy;
	}
}
