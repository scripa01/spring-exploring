package com.example.springexploring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountOrdersByUserDTO {
    private Long userID;

    private String fullName;

    private Long count;

    private String orderId;
}
