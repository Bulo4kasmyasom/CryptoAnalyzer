package ru.javarush.cryptoanalyzer.sternard.controller;
import ru.javarush.cryptoanalyzer.sternard.Enumerations.EActions;
import ru.javarush.cryptoanalyzer.sternard.exceptions.HandlerExceptions;
import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.ACTION_NOT_FOUND;

public class Controller {

    public ResultCode checkParameters(String[] params) {
        try {
            String action = params[0];
            EActions.valueOf(action);
            String regExp = "(^(" + action + ")(\\s\\w+\\.txt){2}(\\s\\d{1,2})?$)";
            Matcher matcher = Pattern.compile(regExp).matcher(String.join(" ", params));
            return (matcher.find()) ? ResultCode.OK : ResultCode.ERROR;

        } catch (IllegalArgumentException e) {
            throw new HandlerExceptions(ACTION_NOT_FOUND + Arrays.toString(EActions.values()), e.getCause());
        }
    }

    public Result execute(String[] params) {
        return EActions.valueOf(params[0]).getAction(params[0]).returnExecute(params);
    }

}