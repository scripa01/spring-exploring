package com.example.springexploring.controller;

import com.example.springexploring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;


    @GetMapping("/users")
    public List<UserDTO> findAll() {
        return jsonPlaceHolderClient.getUsers();
    }

    @GetMapping("user/{postId}")
    public UserDTO findById(@PathVariable("postId") Long postId) {
        return jsonPlaceHolderClient.getUserById(postId);
    }
}
