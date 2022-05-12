package com.example.customerprovider.controller;


import com.example.customerprovider.dao.CustomerDao;
import com.example.customerui.feign.CustomerUIFeign;
import com.example.goodscommon.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerDao customerDao;


    @RequestMapping("/list")
    public List<Customer> list(){
        return customerDao.getCustomerList();
    }

    @RequestMapping("/detail")
    public Customer detail(@RequestParam("id")Integer id){
       return customerDao.getCustomerDetail(id);
    }
}
