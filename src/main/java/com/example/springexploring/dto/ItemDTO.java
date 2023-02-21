package com.example.springexploring.dto;

import com.example.springexploring.entity.Review;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private List<ReviewDTO> reviews;
    private LocalDateTime creationDate;
}
