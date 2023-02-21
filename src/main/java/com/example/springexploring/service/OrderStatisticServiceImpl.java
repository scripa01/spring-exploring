package com.example.springexploring.service;

import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.OrderStatisticDTO;
import com.example.springexploring.entity.Order;
import com.example.springexploring.exception.CustomRuntimeException;
import com.example.springexploring.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
class OrderStatisticServiceImpl implements OrderStatisticService {

    private final OrderRepository orderRepository;

    private final Mapper<Order, OrderStatisticDTO> orderStatisticDTOMapper;

    @Override
    public List<OrderStatisticDTO> findAll() {
        return orderStatisticDTOMapper.mapList(orderRepository.findAll());
    }

    @Override
    public OrderStatisticDTO findById(Long orderId) {
        return orderStatisticDTOMapper.map(orderRepository.findById(orderId).orElseThrow(() -> new CustomRuntimeException("Order with id - " + orderId + " not found")));
    }
}
