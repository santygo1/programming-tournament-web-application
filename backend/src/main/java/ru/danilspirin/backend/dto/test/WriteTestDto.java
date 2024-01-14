package ru.danilspirin.backend.dto.test;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WriteTestDto {

    String input;
    String output;
}