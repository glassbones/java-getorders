package com.ls.order.services;

import com.ls.order.models.Customer;
import com.ls.order.views.OrderCounts;

import java.util.List;

public interface CustomerServ {
    Customer save(Customer customer);

    List<Customer> findAllCustomers();
    List<Customer> findByNameLike(String subname);
    List<OrderCounts> getOrderCounts();
    List<Customer> findByAgentArea(String workingarea);
    Customer findCustomerById(long custcode);
    Customer findByCustname(String custname);
}
