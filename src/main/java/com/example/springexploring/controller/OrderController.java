package com.example.springexploring.controller;


import com.example.springexploring.controller.AddCommand.AddOrderCommand;
import com.example.springexploring.controller.AddCommand.DeliveredOrderCommand;
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

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @PutMapping()
    public void update(@RequestBody UpdateOrderCommand updateOrderCommand) {
        orderService.update(updateOrderCommand);
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable Long orderId) {
        orderService.delete(orderId);
    }

    @PostMapping("/deliver")
    public void deliveredOrder(@RequestBody DeliveredOrderCommand deliveredOrderCommand) {

        orderService.setDeliveryStatus(deliveredOrderCommand.getOrderId(), deliveredOrderCommand.getUserId());                //Jackson конвертирует эти объекты в JSON
    }

}
