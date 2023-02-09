package com.example.springexploring.service;

import com.example.springexploring.controller.AddUserCommand;
import com.example.springexploring.controller.UpdateUserCommand;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.entity.User;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Mapper<User, UserDTO> userDTOMapper;
    @Override
    @Transactional
    public void save(AddUserCommand command) {
        User user = new User(command.getFirstName(), command.getLastName(), command.getAge());
        userRepository.save(user);
    }
    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return userDTOMapper.mapList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        return userDTOMapper.map(userRepository.findById(id).orElseThrow());
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
