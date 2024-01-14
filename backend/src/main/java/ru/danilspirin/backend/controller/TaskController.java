package ru.danilspirin.backend.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.danilspirin.backend.dto.task.ReadTaskDto;
import ru.danilspirin.backend.dto.task.WriteTaskDto;
import ru.danilspirin.backend.model.Task;
import ru.danilspirin.backend.service.task.TaskService;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
@FieldDefaults(level = AccessLevel.PRIVATE)
@PreAuthorize("hasRole('ADMIN')")
public class TaskController {

    final TaskService taskService;
    final ModelMapper mapper;

    public TaskController(TaskService taskService, ModelMapper mapper) {
        this.taskService = taskService;
        this.mapper = mapper;
    }

    
    @GetMapping
    public ResponseEntity<Iterable<ReadTaskDto>> getTaskList() {
        Iterable<ReadTaskDto> list = taskService.getTaskList().stream()
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