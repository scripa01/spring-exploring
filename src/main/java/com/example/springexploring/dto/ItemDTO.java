package com.example.springexploring.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ItemDTO {
    private Long itemId;
    private String name;
    private String description;
    private int price;
    private List<ReviewDTO> reviews;
    private LocalDateTime creationDate;
}
