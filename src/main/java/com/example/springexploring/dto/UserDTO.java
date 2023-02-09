package com.example.springexploring.dto;

import com.example.springexploring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private int age;
    private long rating;

}
