package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournaments")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserController {
}
