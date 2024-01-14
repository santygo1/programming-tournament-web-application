package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.danilspirin.backend.dto.test.ReadTestDto;
import ru.danilspirin.backend.dto.test.WriteTestDto;
import ru.danilspirin.backend.model.Test;
import ru.danilspirin.backend.service.test.TestService;

import java.net.URI;

@RestController
@RequestMapping("/tests")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestController {

    final TestService testService;
    final ModelMapper mapper;

    public TestController(TestService testService, ModelMapper mapper) {
        this.testService = testService;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<Iterable<ReadTestDto>> getTestList() {
        Iterable<ReadTestDto> list = testService.getTestList().stream()
                .map(r -> mapper.map(r, ReadTestDto.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{testId}")
    public ResponseEntity<ReadTestDto> getTestById(@PathVariable Long testId) {
        ReadTestDto test = mapper.map(testService.getTest(testId), ReadTestDto.class);

        return ResponseEntity.ok(test);
    }


    @PostMapping
    public ResponseEntity<ReadTestDto> createTest(@RequestBody WriteTestDto testToCreate) {
        ReadTestDto createdTest = mapper.map(
                testService.createTest(mapper.map(testToCreate, Test.class)),
                ReadTestDto.class
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTest.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(createdTest);
    }

    @PutMapping("/{testId}")
    public ResponseEntity<ReadTestDto> updateTest(
            @PathVariable Long testId,
            @RequestBody WriteTestDto testToUpdate) {

        ReadTestDto updatedTest = mapper.map(
                testService.replaceTest(testId, mapper.map(testToUpdate, Test.class)),
                ReadTestDto.class
        );

        return ResponseEntity.ok(updatedTest);
    }

    @DeleteMapping("/{testId}")
    public ResponseEntity<Void> deleteTestById(@PathVariable Long testId) {
        testService.deleteTest(testId);
        return ResponseEntity.noContent().build();
    }

}