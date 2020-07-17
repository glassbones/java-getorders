package com.ls.order.services;


import com.ls.order.models.Order;

import java.util.List;

public interface OrderServ{
    Order save(Order order);

    List<Order> findAllOrders();
    Order findOrderById(long ordernum);
}