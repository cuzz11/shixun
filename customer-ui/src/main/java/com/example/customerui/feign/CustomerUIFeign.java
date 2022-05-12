package com.example.customerui.feign;

import com.example.goodscommon.pojo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "customer-provider")
public interface CustomerUIFeign {

    @GetMapping("/customer/list")
    List<Customer> getCustomerList();

    @GetMapping("/customer/detail")
    Customer getCustomerDetail(@RequestParam("id") Integer id);
}
