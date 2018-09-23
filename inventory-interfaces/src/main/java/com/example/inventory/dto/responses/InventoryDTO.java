package com.example.inventory.dto.responses;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
@Data
@AllArgsConstructor
public class InventoryDTO  implements Serializable{
	Long id;
	String busName;
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
}
