package com.example.springexploring.service;

import com.example.springexploring.controller.AddItemCommand;
import com.example.springexploring.entity.Item;
import com.example.springexploring.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    @Override
    @Transactional
    public void save(AddItemCommand command) {
        Item item = new Item(command.getName(),command.getDescription(),command.getPrice(),command.getUserId());
        itemRepository.save(item);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
            return itemRepository.findAll();
    }
}
