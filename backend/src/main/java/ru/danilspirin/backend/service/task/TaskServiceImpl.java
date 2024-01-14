package ru.danilspirin.backend.service.task;

import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.task.TaskNotFoundException;
import ru.danilspirin.backend.model.Task;
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
    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long taskId) {
        Optional<Task> findById = taskRepository.findById(taskId);

        if (findById.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        return findById.get();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task replaceTask(Long taskId, Task taskToReplace) {
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