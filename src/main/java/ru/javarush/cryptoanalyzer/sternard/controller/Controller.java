package ru.javarush.cryptoanalyzer.sternard.controller;

import ru.javarush.cryptoanalyzer.sternard.Enumerations.Actions;
import ru.javarush.cryptoanalyzer.sternard.actions.ReaderWriter;
import ru.javarush.cryptoanalyzer.sternard.exceptions.ActionsParamsExceptions;

public class Controller {

    public String doAction(String action, String[] params) {

        return new ReaderWriter().Reader(findParams(findAction(action), params));
    }

    public String findAction(String action) {
        for (Actions act : Actions.values()) {
            if (action.equalsIgnoreCase(act.name())) {
                return action;
            }
        }
        throw new ActionsParamsExceptions("Unknown command in action");
    }

    public String[] findParams(String action, String[] params) {
        if ((action.equalsIgnoreCase(Actions.ENCRYPTION.name()) ||
                action.equalsIgnoreCase(Actions.KEY_DECRYPTION.name())) &&
                params.length == 3) {
//            String methodOfDecryption = params[0]; // with_key, brute_force, statistic_analyse
//            String fileToDecrypt = params[1]; // encrypted.txt
//            String decryptedFile = params[2]; //  decrypted.txt
            return params;


        } else if ((action.equalsIgnoreCase(Actions.BRUTE_FORCE_DECRYPTION.name()) ||
                action.equalsIgnoreCase(Actions.STAT_ANALYSE_DECRYPTION.name())) &&
                params.length == 2) {
            return params;

        } else {
            throw new ActionsParamsExceptions("Check parameters");
        }

    }
}
