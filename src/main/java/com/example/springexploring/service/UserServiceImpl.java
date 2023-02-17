package com.example.springexploring.service;

import com.example.springexploring.controller.AddCommand.AddUserCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateUserCommand;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.entity.User;
import com.example.springexploring.exception.CustomRuntimeException;
import com.example.springexploring.repository.OrderRepository;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

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
        return userDTOMapper.map(userRepository.findById(id).orElseThrow(() -> new CustomRuntimeException("user with id - " + id + " not found")));
    }

    @Override
    public boolean checkIfUserAreOwner(Long userId, Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new CustomRuntimeException("Order with id - " + orderId + " not found")).getUserWhoOrd().getId().
                equals(userId);
    }

    @Transactional
    public void update(UpdateUserCommand updatedPerson) {
        User user = userRepository.findById(updatedPerson.getId()).orElseThrow(() -> new CustomRuntimeException("user with id - " + updatedPerson.getId() + " not found"));
        user.setAge(updatedPerson.getAge());
        user.setFirstName(updatedPerson.getFirstName());
        user.setLastName(updatedPerson.getLastName());
        userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
