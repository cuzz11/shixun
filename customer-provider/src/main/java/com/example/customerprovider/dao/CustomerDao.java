package com.example.customerprovider.dao;

import com.example.goodscommon.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomerList();

    Customer getCustomerDetail(Integer id);

}
