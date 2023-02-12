package com.example.springexploring.controller;


import com.example.springexploring.controller.AddCommand.AddOrderCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateOrderCommand;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.findById(id));
    }
    @PutMapping()
    public void update( @RequestBody UpdateOrderCommand updateOrderCommand) {
        orderService.update(updateOrderCommand);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        orderService.delete(id);
    }

}
