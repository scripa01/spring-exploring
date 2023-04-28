package com.example.springexploring.service;

import com.example.springexploring.controller.AddCommand.AddItemCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateItemCommand;
import com.example.springexploring.dto.ItemDTO;

import java.util.List;

public interface ItemService {


    void save(AddItemCommand command);

    List<ItemDTO> findAll();

    ItemDTO findById(Long id);

    void update( UpdateItemCommand updatedItem);

    void delete(Long id);
}
