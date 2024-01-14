package ru.danilspirin.backend.service.task;

import ru.danilspirin.backend.model.enitiy.TaskModel;

import java.util.List;

public interface TaskService {

    List<TaskModel> getTaskList();

    TaskModel getTask(Long taskId);

    TaskModel createTask(TaskModel task);

    TaskModel replaceTask(Long taskId, TaskModel taskToReplace);

    void deleteTask(Long taskId);
}