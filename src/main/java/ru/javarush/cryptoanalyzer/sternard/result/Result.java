package ru.javarush.cryptoanalyzer.sternard.result;

import ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors;

public class Result {
    private final ResultCode resultCode;
    private final String message;

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if(getResultCode()==ResultCode.OK)
        {
            return ConsoleColors.GREEN_BOLD + ResultCode.OK + "\n"
                    + ConsoleColors.RESET + ConsoleColors.GREEN_BOLD_BRIGHT +
                    getMessage() + ConsoleColors.RESET;
        } else if (getResultCode()==ResultCode.ERROR) {
            return ConsoleColors.RED_BOLD + ResultCode.OK + "\n"
                    + ConsoleColors.RESET + ConsoleColors.RED_BOLD_BRIGHT +
                    getMessage() + ConsoleColors.RESET;
        }
        else if (getResultCode()==ResultCode.FAILED)
        {
            return ConsoleColors.YELLOW_BOLD + ResultCode.OK + "\n"
                    + ConsoleColors.RESET + ConsoleColors.YELLOW_BOLD_BRIGHT +
                    getMessage() + ConsoleColors.RESET;
        }
        return "";
    }
}
