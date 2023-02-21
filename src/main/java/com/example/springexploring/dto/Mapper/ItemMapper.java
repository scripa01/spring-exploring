package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.ItemDTO;
import com.example.springexploring.dto.ReviewDTO;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemMapper implements Mapper<Item, ItemDTO> {

    private final Mapper<Review, ReviewDTO> reviewDTOMapper;

    @Override
    public ItemDTO map(Item entity) {
        return ItemDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .reviews(reviewDTOMapper.mapList(entity.getReviews()))
                .price(entity.getPrice())
                .creationDate(entity.getCreationDate())
                .build();
    }
}
