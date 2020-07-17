package com.ls.order.controllers;

import com.ls.order.models.Order;
import com.ls.order.models.Order;
import com.ls.order.services.OrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderServ orderServ;

    //http://localhost:1337/orders/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllOrders(){
        List<Order> myOrders = orderServ.findAllOrders();
        return new ResponseEntity<>(myOrders, HttpStatus.OK);
    }

    //http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{ordernum}", produces = {"application/json"})
    public ResponseEntity<?> findOrderById(@PathVariable long ordernum){
        Order a = orderServ.findOrderById(ordernum);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}
