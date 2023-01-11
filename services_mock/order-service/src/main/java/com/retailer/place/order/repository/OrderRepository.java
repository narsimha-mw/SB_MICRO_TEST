package com.retailer.place.order.repository;

import com.retailer.place.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByOrderName(String orderName);
    Order findByOrderName(String orderName);
    }
