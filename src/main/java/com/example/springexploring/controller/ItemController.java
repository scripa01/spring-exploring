package com.example.springexploring.controller;

import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.UserDto;
import com.example.springexploring.entity.Item;
import com.example.springexploring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor // DI
public class ItemController {

    private final ItemService itemService;

    private final ModelMapper modelMapper;

    @PostMapping
    public void save(@RequestBody AddItemCommand command) {
        itemService.save(command);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAll() {
        return ResponseEntity.ok(itemService.findAll().stream().
                map(this::convertToItemDTO).collect(Collectors.toList())); //Jackson конвертирует эти объекты в JSON
    }






    private Item convertToItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }
    private ItemDTO convertToItemDTO(Item item){
        return modelMapper.map(item,ItemDTO.class);
    }
}
