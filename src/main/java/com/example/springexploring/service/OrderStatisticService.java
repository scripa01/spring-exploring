package com.example.springexploring.service;


import com.example.springexploring.dto.CountOrdersByUserDTO;
import com.example.springexploring.dto.OrderStatisticDTO;

import java.util.List;

public interface OrderStatisticService {
    List<OrderStatisticDTO> findAll();

    OrderStatisticDTO findById(Long orderId);

    List<CountOrdersByUserDTO> getCountOfOrdersByStatus(String string);
}
