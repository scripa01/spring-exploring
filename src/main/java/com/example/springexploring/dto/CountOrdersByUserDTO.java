package com.example.springexploring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountOrdersByUserDTO {
    Long userID;

    String fullName;

    Long count;

    String orderId;
}
