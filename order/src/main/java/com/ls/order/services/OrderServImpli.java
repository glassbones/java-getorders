package com.ls.order.services;

import com.ls.order.models.Order;
import com.ls.order.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "orderServ")
public class OrderServImpli implements OrderServ {

    @Autowired
    private OrderRepo orderRepos;

    @Transactional
    @Override
    public Order save(Order order) {
        return orderRepos.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> list = new ArrayList<>();

        orderRepos.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Override
    public Order findOrderById(long ordernum) {

        return orderRepos.findById(ordernum)
                .orElseThrow(() -> new EntityNotFoundException("Order " + ordernum + " isn't here my dude."));

    }
}
