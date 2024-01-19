package ru.danilspirin.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unsupported filter")
public class UnsupportedFilterException extends IllegalArgumentException{

    public UnsupportedFilterException() {
        super();
    }

    public UnsupportedFilterException(String category) {
        super("Filter " + category + " is unsupported");
    }
}
