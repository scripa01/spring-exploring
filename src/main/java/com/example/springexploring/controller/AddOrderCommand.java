package com.example.springexploring.controller;

import lombok.Data;

import java.util.List;

@Data   //В комманде только айди!!!
public class AddOrderCommand {

    private List<Long> items;

    private Long userId;
}
