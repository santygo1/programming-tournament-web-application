package ru.danilspirin.backend.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.record.Role;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReadUserDto {

    Long id;
    String name;
    String email;
    String password;
    Role role;
}