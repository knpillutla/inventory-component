package com.example.inventory.exception;

import com.example.inventory.dto.events.Event;

import lombok.Data;

@Data
public class InventoryException extends Exception{
	Event event = null;
	public InventoryException(Event event) {
		super(event.getErrorMsg());
		this.event = event;
	}

}
