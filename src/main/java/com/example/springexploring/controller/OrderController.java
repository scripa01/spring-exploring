package com.example.springexploring.controller;


import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.service.ItemService;
import com.example.springexploring.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor // DI
public class OrderController {
    private final OrderService orderService;


    @PostMapping
    public void save(@RequestBody AddOrderCommand command) {
        orderService.save(command);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.ok(orderService.findAll()); //Jackson конвертирует эти объекты в JSON
    }




}
