package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
public class BlueDart implements Courier {
    @Override
    public String deliver(int orderId) {
        return "Order " + orderId + " will be delivered by BlueDart";
    }
}