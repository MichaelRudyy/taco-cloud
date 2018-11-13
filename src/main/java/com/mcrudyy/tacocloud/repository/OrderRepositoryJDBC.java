package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryJDBC implements OrderRepository {
    @Override
    public Order save(Order order) {
        return null;
    }
}
