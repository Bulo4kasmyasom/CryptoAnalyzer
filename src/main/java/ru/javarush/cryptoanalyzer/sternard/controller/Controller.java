package ru.javarush.cryptoanalyzer.sternard.controller;

import ru.javarush.cryptoanalyzer.sternard.application.EActions;
import ru.javarush.cryptoanalyzer.sternard.mode.console.MenuHandler;
import ru.javarush.cryptoanalyzer.sternard.exceptions.HandlerExceptions;
import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.mode.swing.GUI_CryptoAnalyzer;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.*;
import static ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors.*;

public class Controller {
    public void run(String[] args, Controller controller) {
        if (args.length > 0 && args.length <= 4) {
            System.out.println(controller.execute(controller.checkParameters(args)));
        } else {
            System.out.println(GUI_OR_CONSOLE);
            Scanner scan = new Scanner(System.in);
            String GUIorConsole = scan.nextLine();

            if (GUIorConsole.equalsIgnoreCase(GUI)) {
                new GUI_CryptoAnalyzer().setVisible(true);
            } else if (GUIorConsole.equalsIgnoreCase(CONSOLE)) {
                MenuHandler menu = new MenuHandler(scan);
                do {
                    menu.showMenu();
                    System.out.println(controller.execute(controller.checkParameters(menu.returnParamsFromMenu())));
                    System.out.println(PURPLE_BOLD + EXIT_OR_CONTINUE + RESET);
                } while (!scan.nextLine().equalsIgnoreCase(EXIT_PROGRAM));
            } else {
                System.out.println(RED_BRIGHT + WRONG_PARAMETERS + RESET);
            }
        }
    }

    public String[] checkParameters(String[] params) {
        try {
            String action = params[0];
            EActions.valueOf(action);
            String checkParams;
            if(action.equals(EActions.BRUTE_FORCE_DECRYPTION.name()))
                checkParams = "(^(" + action + ")(\\s\\w+\\.txt){2}$)";
            else
                checkParams = "(^(" + action + ")(\\s\\w+\\.txt){2}(\\s\\d{1,3})$)";
            /*
            Ещё был такой вариант (явно хуже, чем то, что выше):
            (^(ENCRYPTION|KEY_DECRYPTION)(\s\w+\.txt){2}(\s\d{1,3})$)|(^(BRUTE_FORCE_DECRYPTION|STAT_ANALYSE_DECRYPTION)(\s\w+\.txt){2})$
            или вместо ENCRYPTION и т.д. писать EActions.ENCRYPTION.name() ...
             */

            Matcher matcher = Pattern.compile(checkParams).matcher(String.join(" ", params));
            if (matcher.find()) {
                return params;
            } else {
                throw new HandlerExceptions(RED_BRIGHT + WRONG_PARAMETERS + RESET);
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            throw new HandlerExceptions(ACTION_NOT_FOUND, e.getStackTrace());
        }
    }

    public Result execute(String[] params) {
        return EActions.valueOf(params[0]).getAction(params[0]).returnExecute(checkParameters(params));
    }

}