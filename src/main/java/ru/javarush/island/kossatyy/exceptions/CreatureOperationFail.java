package ru.javarush.island.kossatyy.exceptions;

public class CreatureOperationFail extends RuntimeException {
    public CreatureOperationFail() {
    }

    public CreatureOperationFail(String message) {
        super(message);
    }

    public CreatureOperationFail(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatureOperationFail(Throwable cause) {
        super(cause);
    }
}
