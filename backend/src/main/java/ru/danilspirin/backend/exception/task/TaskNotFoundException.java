package ru.danilspirin.backend.exception.task;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task with id " + ("'" + id + "'") + " isn't founded.");
    }
}