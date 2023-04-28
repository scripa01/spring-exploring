package com.example.springexploring.controller;

import com.example.springexploring.controller.AddCommand.AddUserCommand;
import com.example.springexploring.controller.AddCommand.VoteCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateUserCommand;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.service.OrderService;
import com.example.springexploring.service.RatingService;
import com.example.springexploring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor // DI
public class UserController {

    private final UserService userService;
    private final OrderService orderService;
    private final RatingService ratingService;

    @PostMapping
    public void save(@RequestBody @Valid AddUserCommand command) {
        userService.save(command);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateUserCommand updateUserCommand) {
        userService.update(updateUserCommand);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody VoteCommand command) {
        ratingService.vote(command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<OrderDTO>> findAllOrders(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findAllByUserWhoOrd_Id(id)); //Jackson конвертирует эти объекты в JSON
    }


//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleException(RuntimeException e) {
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
}
