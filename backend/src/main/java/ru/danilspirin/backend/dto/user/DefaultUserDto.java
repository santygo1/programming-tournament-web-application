package ru.danilspirin.backend.dto.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.Role;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultUserDto {
    Long id;
    Role role;
    String username;
}
