package com.example.inventory.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface InventoryStreams {
    String ORDERS_OUTPUT = "orders-out";
    String PUTAWAY_OUTPUT = "putaway-out";
    String INVENTORY_OUTPUT = "inventory-out";
    
    @Input(ORDERS_OUTPUT)
    public SubscribableChannel outboundOrders();
    
    @Input(PUTAWAY_OUTPUT)
    SubscribableChannel inboundPutaway();

    @Output(INVENTORY_OUTPUT)
    MessageChannel outboundInventory();
}