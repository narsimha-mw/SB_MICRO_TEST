package com.retailer.place.order.repository;

import com.retailer.place.order.model.PlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceOrderRepository extends JpaRepository<PlaceOrder,Integer> {
    List<PlaceOrder> findAllByOrderName(String orderName);
}
