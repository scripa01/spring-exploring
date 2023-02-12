package com.example.springexploring.controller.AddCommand;

import lombok.Data;

import java.util.List;

@Data   //В комманде только айди!!!
public class AddOrderCommand {

    private List<Long> itemsId;

    private Long userId;
}
