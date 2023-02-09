package com.example.springexploring.service;

import com.example.springexploring.controller.AddOrderCommand;
import com.example.springexploring.controller.UpdateOrderCommand;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.OrderDTO;
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
    private final Mapper<Order,OrderDTO> orderDTOMapper;

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
        return orderDTOMapper.mapList(orderRepository.findAll());
    }
    @Override
    public OrderDTO findById(Long id) {
        return orderDTOMapper.map(orderRepository.findById(id).orElseThrow());
    }
    @Override
    public void update(UpdateOrderCommand updatedOrder) {
        Order order = orderRepository.findById(updatedOrder.getId()).orElseThrow();
        order.setUserWhoOrd(userRepository.findById(updatedOrder.getUserId()).orElseThrow());
        order.setItems(itemRepository.findAllById(updatedOrder.getItems()));
        orderRepository.save(order);
    }
    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
