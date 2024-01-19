package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.danilspirin.backend.dto.task.ReadTaskDto;
import ru.danilspirin.backend.dto.task.WriteTaskDto;
import ru.danilspirin.backend.exception.UnsupportedCategoryException;
import ru.danilspirin.backend.model.Task;
import ru.danilspirin.backend.model.records.Category;
import ru.danilspirin.backend.service.task.TaskService;
import ru.danilspirin.backend.service.task.TaskServiceImpl;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TaskController {

    final TaskServiceImpl taskService;
    final ModelMapper mapper;

    public TaskController(TaskServiceImpl taskService,@Qualifier("taskModelMapper") ModelMapper mapper) {
        this.taskService = taskService;
        this.mapper = mapper;
    }


    @GetMapping
    public ResponseEntity<Iterable<ReadTaskDto>> getTaskList(@RequestParam(value = "track", required = false) String categoryRequest,
                                                             @RequestParam(required = false) String sort) {

        Category category = null;
        if (categoryRequest != null && !categoryRequest.equals("ALL")) {
            try {
                category = Category.valueOf(categoryRequest);
            } catch (IllegalArgumentException e) {
                throw new UnsupportedCategoryException(categoryRequest);
            }
        }

        Sort sortRequest = Sort.unsorted();
        if (sort != null) {
            switch (sort) {
                case "NAME_DESC" -> sortRequest = Sort.by("title").descending();
                case "NAME_ASC" -> sortRequest = Sort.by("title").ascending();
                default -> sortRequest = Sort.unsorted();
            }
        }

        log.info("Тесты для 1: {}", taskService.getTaskList().getFirst().getTests());

        Iterable<ReadTaskDto> list = taskService.getTaskList(Optional.ofNullable(category), sortRequest).stream()
                .map(r -> mapper.map(r, ReadTaskDto.class)).toList();


        return ResponseEntity.ok(list);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ReadTaskDto> getTaskById(@PathVariable Long taskId) {
        ReadTaskDto task = mapper.map(taskService.getTask(taskId), ReadTaskDto.class);

        return ResponseEntity.ok(task);
    }


    @PostMapping
    public ResponseEntity<ReadTaskDto> createTask(@RequestBody WriteTaskDto taskToCreate) {
        ReadTaskDto createdTask = mapper.map(
                taskService.createTask(mapper.map(taskToCreate, Task.class)),
                ReadTaskDto.class
        );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTask.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(createdTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<ReadTaskDto> updateTask(
            @PathVariable Long taskId,
            @RequestBody WriteTaskDto taskToUpdate) {

        ReadTaskDto updatedTask = mapper.map(
                taskService.replaceTask(taskId, mapper.map(taskToUpdate, Task.class)),
                ReadTaskDto.class
        );

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

}