package com.example.springexploring.controller;


import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
public class DeliveredOrderCommand {

    private Long id;
    @NotNull
    private Long userId;
}
