package com.example.springexploring.service;

import com.example.springexploring.controller.AddUserCommand;
import com.example.springexploring.controller.UpdateUserCommand;
import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.entity.User;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void save(AddUserCommand command) {
        User user = new User(command.getFirstName(), command.getLastName(), command.getAge());
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(UserDTO.map(user));
        }
        return dtos;
    }
    @Transactional
    public void update( UpdateUserCommand updatedPerson){
        User user = userRepository.findById(updatedPerson.getId()).orElseThrow();
        user.setAge(updatedPerson.getAge());
        user.setFirstName(updatedPerson.getFirstName());
        user.setLastName(updatedPerson.getLastName());
        userRepository.save(user);
    }
    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
