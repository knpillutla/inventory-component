package com.example.inventory.exception;

import com.example.inventory.dto.events.BaseEvent;

import lombok.Data;

@Data
public class InventoryException extends Exception{
	BaseEvent event = null;
	public InventoryException(BaseEvent event) {
		super(event.getErrorMsg());
		this.event = event;
	}

}
