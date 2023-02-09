package com.example.springexploring.service;

import com.example.springexploring.controller.AddOrderCommand;
import com.example.springexploring.controller.UpdateOrderCommand;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Order;

import java.util.Arrays;
import java.util.List;

public interface OrderService {


    void save(AddOrderCommand command);

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    void update( UpdateOrderCommand updatedOrder);

    void delete(Long id);
}
