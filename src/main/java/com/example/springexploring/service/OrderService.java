package com.example.springexploring.service;

import com.example.springexploring.controller.AddCommand.AddOrderCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateOrderCommand;
import com.example.springexploring.dto.OrderDTO;

import java.util.List;

public interface OrderService {


    void save(AddOrderCommand command);

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    void update(UpdateOrderCommand updatedOrder);

    void delete(Long id);

    List<OrderDTO> findAllByUserWhoOrd_Id(Long id);

    void setDeliveryStatus(Long id);
}
