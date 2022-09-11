package dev.allokanic.yando.exception;

public class YandoException extends RuntimeException {
    public YandoException() {

    }

    public YandoException(String message) {
        super(message);
    }
}
