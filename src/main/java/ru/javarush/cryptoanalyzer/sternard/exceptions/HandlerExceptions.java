package ru.javarush.cryptoanalyzer.sternard.exceptions;

import ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors;

public class HandlerExceptions extends RuntimeException {
    public HandlerExceptions() {
    }

    public HandlerExceptions(String message) {
        super(ConsoleColors.RED_BACKGROUND_BRIGHT + message + ConsoleColors.RESET);
    }

    public HandlerExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
