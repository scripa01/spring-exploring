package com.example.springexploring.controller;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateUserCommand {

  private Long id;
  private String firstName;
  private String lastName;
  private int age;
}
