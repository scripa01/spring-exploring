package com.example.springexploring.service;

import com.example.springexploring.dto.CountOrdersByUserDTO;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.OrderStatisticDTO;
import com.example.springexploring.entity.Order;
import com.example.springexploring.exception.CustomRuntimeException;
import com.example.springexploring.projection.CountOrdersByUserProjections;
import com.example.springexploring.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
class OrderStatisticServiceImpl implements OrderStatisticService {

    private final OrderRepository orderRepository;

    private final Mapper<Order, OrderStatisticDTO> orderStatisticDTOMapper;

    private final Mapper<CountOrdersByUserProjections, CountOrdersByUserDTO> countDeliveredOrderByUserDTOMapper;

    @Override
    public List<OrderStatisticDTO> findAll() {
        return orderStatisticDTOMapper.mapList(orderRepository.findAll());
    }

    @Override
    public OrderStatisticDTO findById(Long orderId) {
        return orderStatisticDTOMapper.map(orderRepository.findById(orderId).orElseThrow(() -> new CustomRuntimeException("Order with id - " + orderId + " not found")));
    }

    @Override
    public List<CountOrdersByUserDTO> getCountOfOrdersByStatus(Enum status) {
        List<CountOrdersByUserProjections> countListProjections = orderRepository.countOrdersByStatusAndUserWhoOrd(status.name());
        return countDeliveredOrderByUserDTOMapper.mapList(countListProjections);
    }

}
