package com.example.customerui.controller;

import com.example.customerui.feign.CustomerUIFeign;
import com.example.goodscommon.pojo.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerUIFeign customerUIFeign;

    @RequestMapping("/list")
    public List<Customer> list(){
        List<Customer> customers = customerUIFeign.getCustomerList();
        return customers;
    }
    @RequestMapping("/detail/{id}")
    public Customer detail(@PathVariable("id")Integer id){
        return customerUIFeign.getCustomerDetail(id);
    }
}
