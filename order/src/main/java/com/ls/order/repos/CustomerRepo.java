package com.ls.order.repos;

import com.ls.order.models.Customer;
import com.ls.order.views.OrderCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepo extends CrudRepository<Customer, Long> {

    Customer findByCustname(String custname);

    @Query ( value =    "SELECT c.custname as name, count(o.ordnum) as countorders " +
                        "FROM orders o LEFT JOIN customers c " +
                        "ON o.custcode = c.custcode " +
                        "GROUP BY c.custname ORDER BY countorders desc", nativeQuery = true)
    List<OrderCounts> getOrderCounts();

    List<Customer> findByCustnameContainingIgnoringCase(String subname);

    List<Customer> findByAgent_workingareaContainingIgnoringCase(String workingarea);

}
