package com.example.springexploring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private int age;
    private long rating;


}
