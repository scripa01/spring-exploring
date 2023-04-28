package com.example.springexploring.dto;

import com.example.springexploring.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDTO { //Возвращаем ДТО сущности!!!

    private Long orderId;

    private LocalDateTime creationDate;

    private List<ItemDTO> items = new ArrayList<>();

    private UserDTO userWhoOrd;

    private Long TotalPrice;

    private Status status;

    private LocalDateTime deliveryDate;


}
