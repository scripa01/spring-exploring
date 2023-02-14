package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class OrderMapper implements Mapper<Order, OrderDTO> {

    private final Mapper<Item, ItemDTO> itemDTOMapper;
    private final Mapper<User, UserDTO> userDTOMapper;

    @Override
    public OrderDTO map(Order entity) {
        return new OrderDTO(entity.getId(), entity.getCreationDate(), itemDTOMapper.mapList(entity.getItems()), userDTOMapper.map(entity.getUserWhoOrd()), entity.getTotalPrice());
    }
}
