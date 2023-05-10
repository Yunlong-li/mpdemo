package com.example.mpdemo.controller;

import com.example.mpdemo.entity.Orders;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrdersController {

    @Resource
    private OrdersMapper ordersMapper;

    @GetMapping("/orders/findAll")
    public List<Orders> find(){return ordersMapper.selectAllOrdersAndUser();}

}
