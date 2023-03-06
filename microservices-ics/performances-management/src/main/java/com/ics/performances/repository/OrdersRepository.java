package com.ics.performances.repository;

import com.ics.performances.model.Orders;
import com.ics.performances.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
