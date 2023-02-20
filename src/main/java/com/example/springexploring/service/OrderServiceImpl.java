package com.example.springexploring.service;

import com.example.springexploring.controller.AddCommand.AddOrderCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateOrderCommand;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Order;
import com.example.springexploring.entity.Status;
import com.example.springexploring.exception.CustomRuntimeException;
import com.example.springexploring.repository.ItemRepository;
import com.example.springexploring.repository.OrderRepository;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final Mapper<Order, OrderDTO> orderDTOMapper;

    @Override
    @Transactional
    public void save(AddOrderCommand command) {
        Order order = new Order(
                userRepository.findById(command.getUserId()).orElseThrow(() -> new CustomRuntimeException("user with id - " + command.getUserId() + " not found")),
                itemRepository.findAllById(command.getItemsId())
        );

        orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        return orderDTOMapper.mapList(orderRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        return orderDTOMapper.map(orderRepository.findById(id).orElseThrow(() -> new CustomRuntimeException("Order with id - " + id + " not found")));
    }

    @Override
    @Transactional
    public void update(UpdateOrderCommand updatedOrder) {
        Order order = orderRepository.findById(updatedOrder.getId()).orElseThrow(() -> new CustomRuntimeException("Order with id - " + updatedOrder.getId() + " not found"));
        order.setUserWhoOrd(userRepository.findById(updatedOrder.getUserId()).orElseThrow(() -> new CustomRuntimeException("user with id - " + updatedOrder.getUserId() + " not found")));
        order.setItems(itemRepository.findAllById(updatedOrder.getItems()));
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> findAllByUserWhoOrd_Id(Long id) {
        return orderDTOMapper.mapList(orderRepository.findAllByUserWhoOrd_Id(id));
    }

    @Override
    @Transactional
    public void setDeliveryStatus(Long orderId, Long userId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new CustomRuntimeException("Order with id - " + orderId + " not found"));
        assertThatUserAreOwner(userId, order);
        assertThatUserAlreadyReceivedOrder(order);
        order.deliver();
        orderRepository.save(order);
    }

    private void assertThatUserAreOwner(Long userId, Order order) {
        if (!order.getUserWhoOrd().getId().equals(userId))
            throw new CustomRuntimeException("User with Id - " + userId + " dont have order with Id - " + order.getId());
    }

    private void assertThatUserAlreadyReceivedOrder(Order order) {
        if (!order.getStatus().equals(Status.DELIVERED))
            throw new CustomRuntimeException("Order with id - " + order.getId() + " is already delivered");
    }

}
