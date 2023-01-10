package com.retailer.place.order.service;

import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.model.PlaceOrder;
import com.retailer.place.order.repository.PlaceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements  OrderService{
    @Autowired
    private PlaceOrderRepository placeOrderRepository;

    public PlaceOrder saveOrder(PlaceOrder order){
       return placeOrderRepository.save(order);
    }
    public List<PlaceOrder> fetchAllOrders(){
        return placeOrderRepository.findAll();
    }

    @Override
    public OrderResponse getByOrderId(String orderId) {
        return null;
    }

    @Override
    public OrderResponse getByOrderName(String orderName) {
        List<PlaceOrder> listOfOrderNames = placeOrderRepository.findAllByOrderName(orderName);
        System.err.println("listOfOrderNames= "+listOfOrderNames.size());
        List<PlaceOrder> placeOrders =  listOfOrderNames.stream()
                .map(this::placeOrderItems).collect(Collectors.toList());
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setPlaceOrders(placeOrders);
        return orderResponse;
    }

    private PlaceOrder placeOrderItems(PlaceOrder placeOrder) {
        System.err.println("id=" + placeOrder.getOrderName());
        PlaceOrder placeOrder1 = new PlaceOrder();
        placeOrder1.setId(placeOrder.getId());
        placeOrder1.setOrderName(placeOrder.getOrderName());
        placeOrder1.setQuantity(placeOrder.getQuantity());
        placeOrder1.setPrice(placeOrder.getPrice());
        return placeOrder1;
    }

    public PlaceOrder updateOrderBtId(Integer orderId, PlaceOrder order){
        Optional<PlaceOrder> orderIdExists = placeOrderRepository.findById(orderId);
        if(orderIdExists.isPresent()) {
            PlaceOrder placeOrder = placeOrderRepository.findById(orderId).get();
            System.err.println("placeOrder"+placeOrder);
            placeOrder.setOrderName(order.getOrderName());
            placeOrder.setPrice(order.getPrice());
            placeOrder.setQuantity(order.getQuantity());
            return placeOrderRepository.save(placeOrder);
        }else{
            return null;
        }
    }
    public void deleteByOrder(Integer orderId){
        placeOrderRepository.deleteById(orderId);
    }
}
