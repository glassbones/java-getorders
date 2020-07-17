package com.ls.order.controllers;

import com.ls.order.models.Customer;
import com.ls.order.services.CustomerServ;
import com.ls.order.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerServ customerServ;

    //http://localhost:1337/customers/customers
    @GetMapping(value = "/customers", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers() {

        List<Customer> myCustomers = customerServ.findAllCustomers();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);

    }

    //http://localhost:1337/customers/customer/7
    @GetMapping(value = "/customer/{custcode}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(long custcode) {

        Customer a = customerServ.findCustomerById(custcode);
        return new ResponseEntity<>(a, HttpStatus.OK);

    }

    //http://localhost:1337/customers/namelike/mes
    @GetMapping(value = "/namelike/{subname}", produces = {"application/json"})
    public ResponseEntity<?> findCustomersByNameLike(@PathVariable String subname) {
        List<Customer> myCustomers = customerServ.findByNameLike(subname);

        return new ResponseEntity<>(myCustomers, HttpStatus.OK);

    }

    //http://localhost:1337/customers/name/batman
    @GetMapping(value = "/name/{custname}", produces = {"application/json"})
    public ResponseEntity<?> findByCustname(@PathVariable String custname) {

        Customer c = customerServ.findByCustname(custname);
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    //http://localhost:1337/customers/ordercounts
    @GetMapping(value = "/ordercounts", produces = {"application/json"})
    public ResponseEntity<?> findOrderCounts(){

        //name, count
        List<OrderCounts> myOrderCounts = customerServ.getOrderCounts();
        return new ResponseEntity<>(myOrderCounts, HttpStatus.OK);

    }

    //http://localhost:1337/customers/agentWorkingAreaLike/london
    @GetMapping(value = "/agentWorkingAreaLike/{workingarea}", produces = {"application/json"})
    public ResponseEntity<?> findByAgentArea(@PathVariable String workingarea){
        List<Customer> myCustomers = customerServ.findByAgentArea(workingarea);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
}
