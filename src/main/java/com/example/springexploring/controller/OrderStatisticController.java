package com.example.springexploring.controller;

import com.example.springexploring.dto.CountOrdersByUserDTO;
import com.example.springexploring.dto.OrderStatisticDTO;
import com.example.springexploring.entity.Status;
import com.example.springexploring.service.OrderStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders/statistic")
@RequiredArgsConstructor // DI
public class OrderStatisticController {
    private final OrderStatisticService orderStatisticService;

    @GetMapping
    public ResponseEntity<List<OrderStatisticDTO>> findAll() {
        return ResponseEntity.ok(orderStatisticService.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderStatisticDTO> findById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderStatisticService.findById(orderId));
    }

    @GetMapping("/count/non-delivered")
    public ResponseEntity<List<CountOrdersByUserDTO>> countNonDeliveredOrderByUser() {
        return ResponseEntity.ok(orderStatisticService.getCountOfOrdersByStatus(Status.CREATED));
    }

    @GetMapping("/count/delivered")
    public ResponseEntity<List<CountOrdersByUserDTO>> countDeliveredOrderByUser() {
        return ResponseEntity.ok(orderStatisticService.getCountOfOrdersByStatus(Status.DELIVERED));
    }
}
