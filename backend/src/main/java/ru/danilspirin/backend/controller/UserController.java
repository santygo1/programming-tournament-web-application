package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.danilspirin.backend.dto.user.ReadUserDto;
import ru.danilspirin.backend.dto.user.WriteUserDto;
import ru.danilspirin.backend.model.enitiy.UserModel;
import ru.danilspirin.backend.service.user.UserService;

import java.net.URI;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;
    final ModelMapper mapper;

    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<Iterable<ReadUserDto>> getUserList() {
        Iterable<ReadUserDto> list = userService.getUserList().stream()
                .map(r -> mapper.map(r, ReadUserDto.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ReadUserDto> getUserById(@PathVariable Long userId) {
        ReadUserDto user = mapper.map(userService.getUser(userId), ReadUserDto.class);

        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity<ReadUserDto> createUser(@RequestBody WriteUserDto userToCreate) {
        ReadUserDto createdUser = mapper.map(
                userService.createUser(mapper.map(userToCreate, UserModel.class)),
                ReadUserDto.class
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(createdUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ReadUserDto> updateUser(
            @PathVariable Long userId,
            @RequestBody WriteUserDto userToUpdate) {

        ReadUserDto updatedUser = mapper.map(
                userService.replaceUser(userId, mapper.map(userToUpdate, UserModel.class)),
                ReadUserDto.class
        );

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}