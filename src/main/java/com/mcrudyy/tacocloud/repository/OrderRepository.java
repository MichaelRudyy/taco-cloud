package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Order;

public interface OrderRepository {

    Order save(Order order);
}
