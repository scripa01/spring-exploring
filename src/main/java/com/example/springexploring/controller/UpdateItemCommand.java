package com.example.springexploring.controller;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateItemCommand {

  private Long id;
  private String name;
  private String description;
  private int price;

}
