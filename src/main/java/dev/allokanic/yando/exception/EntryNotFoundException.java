package dev.allokanic.yando.exception;

public class EntryNotFoundException extends YandoException {
    public EntryNotFoundException() {

    }

    public EntryNotFoundException(String id) {
        super("Entry with id = \"%s\"".formatted(id));
    }
}
