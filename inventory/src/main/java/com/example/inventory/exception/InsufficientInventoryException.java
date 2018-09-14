package com.example.inventory.exception;

import com.example.inventory.dto.events.Event;

import lombok.Data;

@Data
public class InsufficientInventoryException extends Exception{
	public InsufficientInventoryException(String errorMsg) {
		super(errorMsg);
	}
}
