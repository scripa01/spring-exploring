package com.example.springexploring.dto;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDTO { //Возвращаем ДТО сущности!!!

    private LocalDateTime creationDate;

    private List<ItemDTO> items = new ArrayList<>();

    private User userWhoOrd;

}
