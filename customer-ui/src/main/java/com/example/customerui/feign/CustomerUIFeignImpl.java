package com.example.customerui.feign;

import com.example.goodscommon.pojo.Customer;
import com.example.goodscommon.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUIFeignImpl implements CustomerUIFeign{
    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    @Override
    public ResultVo getCustomerDetail(Integer id) {
        return ResultVo.error("feign服务降低");
    }
}
