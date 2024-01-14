package ru.danilspirin.backend.service.task;

import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.task.TaskNotFoundException;
import ru.danilspirin.backend.model.enitiy.TaskModel;
import ru.danilspirin.backend.repository.TaskRepository;

import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<TaskModel> getTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel getTask(Long taskId) {
        Optional<TaskModel> findById = taskRepository.findById(taskId);

        if (findById.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        return findById.get();
    }

    @Override
    public TaskModel createTask(TaskModel task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskModel replaceTask(Long taskId, TaskModel taskToReplace) {
        taskToReplace.setId(taskId);
        return taskRepository.save(taskToReplace);
    }

    @Override
    public void deleteTask(Long taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
        } else {
            throw new TaskNotFoundException(taskId);
        }
    }
}