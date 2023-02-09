package com.example.springexploring.service;

import com.example.springexploring.controller.AddItemCommand;
import com.example.springexploring.controller.UpdateItemCommand;
import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.OrderDTO;
import com.example.springexploring.entity.Item;

import java.util.List;

public interface ItemService {


    void save(AddItemCommand command);

    List<ItemDTO> findAll();

    ItemDTO findById(Long id);

    void update( UpdateItemCommand updatedItem);

    void delete(Long id);
}
