package com.ved.SpringDataJPA.services;

import com.ved.SpringDataJPA.dto.CreateUserDto;
import com.ved.SpringDataJPA.dto.UserDto;
import com.ved.SpringDataJPA.entity.User;
import com.ved.SpringDataJPA.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public  UserDto createUser(CreateUserDto createUserDto) {
        User newUser = new User();
        newUser.setName(createUserDto.getName());
        newUser.setEmail(createUserDto.getEmail());

        User savedUser = userRepository.save(newUser);
        return new UserDto(savedUser.getId(),savedUser.getName(),savedUser.getEmail());
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = new UserDto(user.getId(),user.getName(),user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return  new UserDto(user.getId(),user.getName(),user.getEmail());
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public UserDto updateUser(long id, CreateUserDto createUserDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(createUserDto.getName());
        user.setEmail(createUserDto.getEmail());

        // no save() needed

        return new UserDto(user.getId(),user.getName(),user.getEmail());
    }

    @Transactional
    public UserDto patchUser(long id, CreateUserDto createUserDto) {
        User user = userRepository.findById(id).orElseThrow();
        if(createUserDto.getName()!=null) {
            user.setName(createUserDto.getName());
        }
        if(createUserDto.getEmail()!=null) {
            user.setEmail(createUserDto.getEmail());
        }
        // no save() required
        return new UserDto(user.getId(),user.getName(),user.getEmail());
    }
}
