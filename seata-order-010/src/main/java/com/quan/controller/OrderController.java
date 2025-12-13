package com.quan.controller;

import com.quan.bean.Order;
import com.quan.mapper.OrderMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @PostMapping("/generateOrder")
    public Integer generateOrder(@RequestBody Order order) {
        return orderMapper.save(order);
    }


}
