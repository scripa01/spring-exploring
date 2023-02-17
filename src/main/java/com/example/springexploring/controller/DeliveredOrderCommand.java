package com.example.springexploring.controller;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class DeliveredOrderCommand {

    @NotNull
    private Long orderId;
    @NotNull
    private Long userId;
}
