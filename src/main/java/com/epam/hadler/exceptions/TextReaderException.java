package com.epam.hadler.exceptions;

public class TextReaderException extends Exception {

    public TextReaderException() {
    }

    public TextReaderException(String message) {
        super(message);
    }

    public TextReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
