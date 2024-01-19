package ru.danilspirin.backend.dto.user;


import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.Role;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorizedUserDto extends DefaultUserDto {

    Role role;
    String email;
}
