package com.example.springexploring.service;

import com.example.springexploring.controller.AddOrderCommand;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.Mapper.OrderMapper;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.repository.ItemRepository;
import com.example.springexploring.repository.OrderRepository;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final Mapper<Order,OrderDTO> orderMapper;

    @Override
    @Transactional
    public void save(AddOrderCommand command) {
        Order order = new Order(
                userRepository.findById(command.getUserId()).orElseThrow(),
                itemRepository.findAllById(command.getItems())
        );
        orderRepository.save(order);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderMapper.mapList(orderRepository.findAll());
    }
}
