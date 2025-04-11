package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.dao.OrderDAO;

@Component("fpkt")
public class Flipkart {
    private Courier courier;

    @Autowired
    private OrderDAO orderDAO;

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String processOrder(String[] items, double[] prices, String courierType) {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }

        int orderId = new Random().nextInt(1000);
        orderDAO.saveOrder(orderId, Arrays.toString(items), total, courierType);

        String deliveryMsg = courier.deliver(orderId);
        return "Items: " + Arrays.toString(items) + ", Total: " + total + " -> " + deliveryMsg;
    }
}