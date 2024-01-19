package ru.danilspirin.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unsupported category")
public class UnsupportedCategoryException extends IllegalArgumentException{

    public UnsupportedCategoryException() {
        super();
    }

    public UnsupportedCategoryException(String category) {
        super("Category " + category + " is unsupported");
    }
}
