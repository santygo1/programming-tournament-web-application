package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.danilspirin.backend.dto.user.AuthorizedUserDto;
import ru.danilspirin.backend.dto.user.DefaultUserDto;
import ru.danilspirin.backend.service.user.UserService;

import java.util.Objects;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserController {

    final UserService userService;
    final ModelMapper mapper;

    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<DefaultUserDto> getUserById(
            @PathVariable Long userId,
            @RequestHeader(name= "x-authorized-user", required = false) Long authUserId) {
        DefaultUserDto user;

        // убрал авторизацию, для этого такой костыль
        if (authUserId != null && Objects.equals(userId, authUserId)) {
            user = mapper.map(userService.getUserById(userId), AuthorizedUserDto.class);
        } else {
            user = mapper.map(userService.getUserById(userId), DefaultUserDto.class);
        }

        return ResponseEntity.ok(user);
    }
}
