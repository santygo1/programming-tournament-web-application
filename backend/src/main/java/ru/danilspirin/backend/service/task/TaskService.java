package ru.danilspirin.backend.service.task;

import ru.danilspirin.backend.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTaskList();

    Task getTask(Long taskId);

    Task createTask(Task task);

    Task replaceTask(Long taskId, Task taskToReplace);

    void deleteTask(Long taskId);
}