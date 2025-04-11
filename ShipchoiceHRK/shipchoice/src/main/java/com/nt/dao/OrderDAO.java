package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public class OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrder(int orderId, String items, double totalAmount, String courierService) {
        String sql = "INSERT INTO orders (order_id, items, total_amount, courier_service, delivery_status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderId, items, totalAmount, courierService, "Pending");
    }
}