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
    private int rating;

    public static UserDTO map(User user) {
        return new UserDTO(user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getRating());
    }
}
