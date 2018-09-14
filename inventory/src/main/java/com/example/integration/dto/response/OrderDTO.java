package com.example.integration.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO  implements Serializable{
	Long id;
	String busName;
	Integer locnNbr;
	String company;
	String division;
	String busUnit;
	String externalBatchNbr;
	String batchNbr;
	String orderNbr;
	Integer statCode;
	Date orderDttm;
	Date shipByDttm;
	Date expectedDeliveryDttm;
	String deliveryType;
	boolean isGift;
	String giftMsg;
	String source;
	String transactionName;
	String refField1;
	String refField2;
	Date updatedDttm;
	String updatedBy;
	private List<OrderLineDTO> orderLines = new ArrayList<>();
	

    public void addOrderLine(OrderLineDTO orderLineDTO) {
    	orderLines.add(orderLineDTO);
    }
 
    public void removeOrderLine(OrderLineDTO orderLineDTO) {
    	orderLines.remove(orderLineDTO);
    }

	public OrderDTO(Long id, String busName, Integer locnNbr, String company, String division, String busUnit,
			String externalBatchNbr, String batchNbr, String orderNbr, Integer statCode, Date orderDttm,
			Date shipByDttm, Date expectedDeliveryDttm, String deliveryType, boolean isGift, String giftMsg,
			String source, String transactionName, String refField1, String refField2, Date updatedDttm,
			String updatedBy) {
		super();
		this.id = id;
		this.busName = busName;
		this.locnNbr = locnNbr;
		this.company = company;
		this.division = division;
		this.busUnit = busUnit;
		this.externalBatchNbr = externalBatchNbr;
		this.batchNbr = batchNbr;
		this.orderNbr = orderNbr;
		this.statCode = statCode;
		this.orderDttm = orderDttm;
		this.shipByDttm = shipByDttm;
		this.expectedDeliveryDttm = expectedDeliveryDttm;
		this.deliveryType = deliveryType;
		this.isGift = isGift;
		this.giftMsg = giftMsg;
		this.source = source;
		this.transactionName = transactionName;
		this.refField1 = refField1;
		this.refField2 = refField2;
		this.updatedDttm = updatedDttm;
		this.updatedBy = updatedBy;
	}

}
