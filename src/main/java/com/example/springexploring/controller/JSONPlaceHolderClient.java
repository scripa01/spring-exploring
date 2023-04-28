package com.example.springexploring.controller;

import com.example.springexploring.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "http://localhost:8080")
public interface JSONPlaceHolderClient {

    @GetMapping( "/user")
    List<UserDTO> getUsers();

    @GetMapping( "/user/{userId}")
    UserDTO getUserById(@PathVariable("userId") Long userId);
}
