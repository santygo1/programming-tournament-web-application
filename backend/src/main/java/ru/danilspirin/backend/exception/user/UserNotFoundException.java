package ru.danilspirin.backend.exception.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User with id " + ("'" + id + "'") + " isn't founded.");
    }
}