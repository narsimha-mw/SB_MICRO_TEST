package com.retailer.services;

import com.retailer.dto.InventoryResponse;
import com.retailer.model.Order;
import com.retailer.model.OrderLineItems;
import com.retailer.dto.OrderRequest;
import com.retailer.dto.OrderLineItemRequest;
import com.retailer.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl implements  OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WebClient webClient;

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
          List<String> listOfSkus = order.getOrderLineItemsList()
                  .stream()
                  .map(OrderLineItems::getSku)
                  .toList();
          // call inventory API, If product has a stock, then order placed
       InventoryResponse[] inventoryResponsesArray = webClient.get()
               .uri("http://localhost:2002/api/inventory",
                       uriBuilder -> uriBuilder.queryParam("sku",listOfSkus).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                        .block();
        boolean response = Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponse::isInStock);
       if(response) {
           orderRepository.save(order);
           log.info("this Order Number {} places successfully", order.getOrderNumber());
       } else{
           throw  new IllegalArgumentException("This Product not in a Stock");
       }
    }
    private OrderLineItems mapToDto(OrderLineItemRequest orderLineItemsRequest) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsRequest.getQuantity());
        orderLineItems.setPrice(orderLineItemsRequest.getPrice());
        orderLineItems.setSku(orderLineItemsRequest.getSku());
        return orderLineItems;
    }
}
