package com.example.springexploring.controller;

import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor // DI
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public void save(@RequestBody AddItemCommand command) {
        itemService.save(command);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAll() {
        return ResponseEntity.ok(itemService.findAll()); //Jackson конвертирует эти объекты в JSON
    }


}
