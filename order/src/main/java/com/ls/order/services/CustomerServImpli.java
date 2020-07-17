package com.ls.order.services;


import com.ls.order.models.Customer;
import com.ls.order.repos.CustomerRepo;
import com.ls.order.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service(value = "customerServ")
public class CustomerServImpli implements CustomerServ {

    @Autowired
    private CustomerRepo customerRepos;

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerRepos.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();

        customerRepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long custcode) {

        return customerRepos.findById(custcode)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + custcode + " isn't here my dude."));

    }

    @Override
    public Customer findByCustname(String custname) {

        Customer c = customerRepos.findByCustname(custname);

        if (c == null){
            throw new EntityNotFoundException("Customer: " + custname + " only exists on opposite day.");
        }

        return c;

    }

    @Override
    public List<Customer> findByNameLike(String subname) {
        return customerRepos.findByCustnameContainingIgnoringCase(subname);
    }

    @Override
    public List<OrderCounts> getOrderCounts() {
        return customerRepos.getOrderCounts();
    }

    @Override
    public List<Customer> findByAgentArea(String workingarea) {
        return customerRepos.findByAgent_workingareaContainingIgnoringCase(workingarea);
    }
}