package com.example.springexploring.controller.UpdateCommand;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ToString
public class UpdateUserCommand {

  private Long id;
  @NotEmpty(message = "Last Name should not be empty")
  @Size(min = 2, max = 30, message = "Name 2-30 characters")
  private String firstName;
  @NotEmpty(message = "First Name should not be empty")
  @Size(min = 2, max = 30, message = "Name 2-30 characters")
  private String lastName;
  @Min(value = 0, message = "Age should be greater than 0")
  private int age;
}
