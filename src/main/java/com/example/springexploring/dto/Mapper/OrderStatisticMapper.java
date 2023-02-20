package com.example.springexploring.dto.Mapper;


import com.example.springexploring.dto.OrderStatisticDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderStatisticMapper implements Mapper<Order, OrderStatisticDTO> {

    @Override
    public OrderStatisticDTO map(Order entity) {
        return OrderStatisticDTO.builder()
                .orderId(entity.getId())
                .userId(entity.getUserWhoOrd().getId())
                .userName(entity.getUserWhoOrd().getFirstName())
                .orderedDate(entity.getCreationDate())
                .receivedDate(entity.getDeliveryDate())
                .daysDifference(entity.getDifferenceDaysDelivery())
                .status(entity.getStatus())
                .itemsId(entity.getItems().stream()
                        .map(Item::getId)
                        .collect(Collectors.toList()))
                .build();
    }
}
