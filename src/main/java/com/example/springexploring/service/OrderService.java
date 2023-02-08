package com.example.springexploring.service;

import com.example.springexploring.controller.AddOrderCommand;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Order;

import java.util.Arrays;
import java.util.List;

public interface OrderService {


    void save(AddOrderCommand command);

    List<OrderDTO> findAll();
}
