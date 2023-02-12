package com.example.springexploring.controller.UpdateCommand;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UpdateOrderCommand {


  private Long id;

  private List<Long> items;

  private Long userId;

}
