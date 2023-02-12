package com.example.springexploring.controller.AddCommand;


import com.example.springexploring.entity.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddItemCommand {

    @NotEmpty(message = "Name of item should not be empty")
    @Size(min = 2, max = 30, message = "Name 2-30 characters")
    private String name;

    @NotEmpty(message = "Description should not be empty")
    @Size(min = 2, max = 300, message = "Name 2-300 characters")
    private String description;

    @NotNull(message = "Price should be greater than 0!")
    @Min(value = 0, message = "price should be greater than 0!")
    private int price;

}
