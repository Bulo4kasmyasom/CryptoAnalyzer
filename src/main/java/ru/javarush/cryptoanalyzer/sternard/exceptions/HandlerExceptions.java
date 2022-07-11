package ru.javarush.cryptoanalyzer.sternard.exceptions;

import ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors;

import static ru.javarush.cryptoanalyzer.sternard.constant.Settings.SHOW_STACKTRACE_ERRORS;
import static ru.javarush.cryptoanalyzer.sternard.constant.Settings.WRITE_TO_LOG_ERRORS;

public class HandlerExceptions extends RuntimeException {
    public HandlerExceptions(String message) {
        showStackTraceOrNo(message);
    }

    public HandlerExceptions(String message, StackTraceElement[] stackTrace) {
        showStackTraceOrNo(message);
        if(WRITE_TO_LOG_ERRORS)
            new WriteToLogs().writeToLogFileException(stackTrace);
    }


    private void showStackTraceOrNo(String message) {
        if(!SHOW_STACKTRACE_ERRORS) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + message + ConsoleColors.RESET);
            System.exit(0); // остановка программы, чтобы не показывать стектрейс
        }
        else
        {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + message + ConsoleColors.RESET);
        }
    }

}