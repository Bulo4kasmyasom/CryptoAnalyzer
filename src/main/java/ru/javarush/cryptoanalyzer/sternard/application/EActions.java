package ru.javarush.cryptoanalyzer.sternard.application;

import ru.javarush.cryptoanalyzer.sternard.actions.BruteForceDecrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.Decrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.Encrypt;

public enum EActions {
    ENCRYPTION(new Encrypt()),
    KEY_DECRYPTION(new Decrypt()),
    BRUTE_FORCE_DECRYPTION(new BruteForceDecrypt());
//    STAT_ANALYSE_DECRYPTION(new StatAnalyseDecrypt()));

    private final doAction action;
    EActions(doAction action) {
        this.action = action;
    }

    public doAction getAction(String command) {
        return EActions.valueOf(command.toUpperCase()).action;
    }

}