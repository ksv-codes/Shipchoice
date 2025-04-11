package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public class DTDC implements Courier {
    @Override
    public String deliver(int orderId) {
        return "Order " + orderId + " will be delivered by DTDC";
    }
}