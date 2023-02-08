package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Order;
import org.springframework.stereotype.Component;
import java.util.Collections;


@Component
public class OrderMapper implements Mapper<Order, OrderDTO> {


    @Override
    public OrderDTO map(Order entity) {
        return new OrderDTO(entity.getCreationDate(), Collections.emptyList(),entity.getUserWhoOrd());
    }
}
