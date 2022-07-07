package ru.javarush.cryptoanalyzer.sternard.exceptions;

public class ActionsParamsExceptions extends RuntimeException{
    public ActionsParamsExceptions() {

    }

    public ActionsParamsExceptions(String message) {
        super(message);
    }

    public ActionsParamsExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
