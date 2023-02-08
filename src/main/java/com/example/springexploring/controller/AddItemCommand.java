package com.example.springexploring.controller;


import com.example.springexploring.entity.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

@Data
public class AddItemCommand {

    private String name;
    private String description;
    private int price;
}
