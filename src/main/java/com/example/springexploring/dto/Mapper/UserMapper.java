package com.example.springexploring.dto.Mapper;


import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {
    @Override
    public UserDTO map(User entity) {
        return new UserDTO( entity.getId(),entity.getFirstName(), entity.getLastName(), entity.getAge(),entity.getRating());
    }
}
