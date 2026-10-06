package com.ved.SpringDataJPA.controllers;

import com.ved.SpringDataJPA.dto.CreateUserDto;
import com.ved.SpringDataJPA.dto.UserDto;
import com.ved.SpringDataJPA.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,createUserDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> PatchUser(@PathVariable long id, @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.patchUser(id,createUserDto));
    }


}
