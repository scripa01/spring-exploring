package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class OrderMapper implements Mapper<Order, OrderDTO> {

    private final Mapper<Item, ItemDTO> itemDTOMapper;
    @Override
    public OrderDTO map(Order entity) {
        return new OrderDTO(entity.getCreationDate(), itemDTOMapper.mapList(entity.getItems()), entity.getUserWhoOrd());
    }
}
