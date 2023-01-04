package com.retailer.order.orderservice.services;

import com.retailer.order.orderservice.dto.order.OrderRequest;
import com.retailer.order.orderservice.dto.order.OrderResponse;
import com.retailer.order.orderservice.dto.orderlineitems.OrderLineItemRequest;
import com.retailer.order.orderservice.model.OrderLineItems;
import com.retailer.order.orderservice.model.Order;
import com.retailer.order.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements  OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void placeTheOrder(OrderRequest orderRequest) {
     Order order = new Order();
     String orderNo= UUID.randomUUID().toString();
     System.err.println(orderNo.length()+ "orderNum befr:"+orderNo);
        order.setOrderNumber(UUID.randomUUID().toString());
          List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemRequestList()
                  .stream()
                  .map(this::mapToDto)
                  .collect(Collectors.toList());
          order.setOrderLineItemsList(orderLineItems);
          orderRepository.save(order);
      log.info("this Order Number {} places successfully", order.getOrderNumber());
    }

    @Override
    public List<OrderResponse> fetchAllOrders(OrderResponse orderResponse) {

        return null;
    }

    private OrderLineItems mapToDto(OrderLineItemRequest orderLineItemsRequest) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsRequest.getQuantity());
        orderLineItems.setPrice(orderLineItemsRequest.getPrice());
        orderLineItems.setSkuCode(orderLineItemsRequest.getSkuCode());
        return orderLineItems;
    }
}
