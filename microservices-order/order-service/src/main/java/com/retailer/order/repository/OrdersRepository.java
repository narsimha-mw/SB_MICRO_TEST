package com.retailer.order.repository;

import com.retailer.order.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<ProductOrder,Integer> {
//    List<Orders> findAllByOrderName(String orderName);
//    Orders findByOrderNameIgnoreCase(String orderName);

    ProductOrder findTopByOrderByIdDesc();

    Optional<ProductOrder> findByOrderNumber(Integer orderId);
}
