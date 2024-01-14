package ru.danilspirin.backend.dto.test;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReadTestDto {

    Long id;
    String input;
    String output;
}