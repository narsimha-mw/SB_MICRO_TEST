//package com.ics.controllers;
//
//import com.ics.configs.TokenHeader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/v2/order")
//@Validated
//public class OrdersController {
//    @Autowired
//    private OrdersService orderService;
//    @Autowired
//    private TokenHeader tokenHeader;
//    @GetMapping("/test-server")
//    @ResponseStatus(HttpStatus.OK)
//    public String testServer(){
////            @RequestHeader (name = "Authorization") String jwtToken) throws UnsupportedEncodingException {
////        String[] chunks = jwtToken.split("\\.");
////        Base64.Decoder decoder = Base64.getUrlDecoder();
////        String userInfo = new String(decoder.decode(chunks[1]));
////        System.err.println("userInfo= "+userInfo);
////        JSONObject jSONObject = new JSONObject(userInfo);
////        System.err.println(jSONObject+ "json "+ jSONObject.getString("sub"));
//
//        return "orderService is up now today....";
//    }
//    private static String decode(String encodedString) {
//        return new String(Base64.getUrlDecoder().decode(encodedString));
//    }
//
//    @CrossOrigin
//    @PostMapping(path="/save-order", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    public OrderPaymentTransactionResponse saveOrder(@RequestBody OrderPaymentTransactionRequest request, HttpRequest httpRequest){
//        System.out.println("Retry API flow"+ httpRequest);
//        return orderService.savedOrder(request);
//    }
//    @CrossOrigin
//    @GetMapping(path="/all", produces = "application/json")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public OrdersResponse fetchAllOrders(){
//
//        List<ProductOrder> responses = orderService.fetchAllOrders();
//        return OrdersResponse.builder().item(responses).build();
//    }
//    @CrossOrigin
//    @GetMapping(path="/orderId={id}&pay-status={paymentStatus}", produces = "application/json")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @ResponseBody
//    public OrderPaymentTransactionResponse filterByOrderPaymentStatus(@PathVariable(value = "id") Integer orderId,
//                                                                      @PathVariable(value = "paymentStatus") Boolean paymentStatus) {
//        return orderService.filterByOrderPaymentStatus(orderId, paymentStatus);
//    }
//}
