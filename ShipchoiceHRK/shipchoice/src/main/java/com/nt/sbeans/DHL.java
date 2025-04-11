package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dhl")
public class DHL implements Courier {
    @Override
    public String deliver(int orderId) {
        return "Order " + orderId + " will be delivered by DHL";
    }
}