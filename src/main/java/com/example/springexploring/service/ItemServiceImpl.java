package com.example.springexploring.service;

import com.example.springexploring.controller.AddItemCommand;
import com.example.springexploring.controller.UpdateItemCommand;
import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.Mapper.Mapper;
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
    private final Mapper<Item, ItemDTO> itemDTOMapper;
    @Override
    @Transactional
    public void save(AddItemCommand command) {
        Item item = new Item(command.getName(),command.getDescription(),command.getPrice());
        itemRepository.save(item);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> findAll() {
            return itemDTOMapper.mapList(itemRepository.findAll());
    }
    @Override
    @Transactional(readOnly = true)
    public ItemDTO findById(Long id) {
        return itemDTOMapper.map(itemRepository.findById(id).orElseThrow());
    }
    @Override
    @Transactional
    public void update(UpdateItemCommand updatedItem) {
        Item item = itemRepository.findById(updatedItem.getId()).orElseThrow();
        item.setName(updatedItem.getName());
        item.setDescription(updatedItem.getDescription());
        item.setPrice(updatedItem.getPrice());
        itemRepository.save(item);
    }
    @Override
    @Transactional
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }


}