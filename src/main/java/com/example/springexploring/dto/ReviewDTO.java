package com.example.springexploring.dto;


import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {

    private Item item;
    private User user;
}
