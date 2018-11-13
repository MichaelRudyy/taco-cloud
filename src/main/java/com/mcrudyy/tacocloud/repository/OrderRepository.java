package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
        extends CrudRepository<Order, Long> {
}
