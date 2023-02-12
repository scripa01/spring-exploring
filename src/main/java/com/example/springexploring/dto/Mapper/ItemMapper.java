package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.entity.Item;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements Mapper<Item, ItemDTO>{

    @Override
    public ItemDTO map(Item entity) {
        return new ItemDTO(entity.getId(), entity.getName(),entity.getDescription(),entity.getPrice(),entity.getCreationDate());
    }
}
