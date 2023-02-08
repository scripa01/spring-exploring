package com.example.springexploring.service;

import com.example.springexploring.controller.AddUserCommand;
import com.example.springexploring.dto.UserDTO;

import java.util.List;

public interface UserService {

  void save(AddUserCommand command);

  List<UserDTO> findAll();
}
