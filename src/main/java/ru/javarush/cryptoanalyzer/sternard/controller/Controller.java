package ru.javarush.cryptoanalyzer.sternard.controller;

import ru.javarush.cryptoanalyzer.sternard.Enumerations.EActions;
import ru.javarush.cryptoanalyzer.sternard.console.MenuHandler;
import ru.javarush.cryptoanalyzer.sternard.exceptions.HandlerExceptions;
import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.*;

public class Controller {
    public void run(String[] args, Controller controller) {
        if (args.length > 0 && args.length <= 4) {
            System.out.println(controller.execute(controller.checkParameters(args)));
        } else {
            Scanner scan = new Scanner(System.in);
            MenuHandler menu = new MenuHandler(scan);
            do {
                menu.showMenu();
                System.out.println(controller.execute(controller.checkParameters(menu.returnParamsFromMenu())));
                System.out.println(EXIT_OR_CONTINUE);
            } while (!scan.nextLine().equalsIgnoreCase("exit"));
        }
    }

    private String[] checkParameters(String[] params) {
        try {
            String action = params[0];
            EActions.valueOf(action);
            String regExp = "(^(" + action + ")(\\s\\w+\\.txt){2}(\\s\\d{1,2})?$)";
            Matcher matcher = Pattern.compile(regExp).matcher(String.join(" ", params));
            if (matcher.find()) {
                return params;
            } else {
                throw new HandlerExceptions(ConsoleColors.RED_BRIGHT + WRONG_PARAMETERS + ConsoleColors.RESET);
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            throw new HandlerExceptions(ACTION_NOT_FOUND, e.getStackTrace());
        }
    }

    private Result execute(String[] params) {
        return EActions.valueOf(params[0]).getAction(params[0]).returnExecute(params);
    }

}