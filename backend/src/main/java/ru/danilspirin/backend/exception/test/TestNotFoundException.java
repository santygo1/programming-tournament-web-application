package ru.danilspirin.backend.exception.test;

public class TestNotFoundException extends RuntimeException {

    public TestNotFoundException(Long id) {
        super("Test with id " + ("'" + id + "'") + " isn't founded.");
    }
}