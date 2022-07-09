package ru.javarush.cryptoanalyzer.sternard.Enumerations;

import ru.javarush.cryptoanalyzer.sternard.actions.BruteForceDecrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.Decrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.Encrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.doAction;

public enum Actions {
    ENCRYPTION(new Encrypt()),
    KEY_DECRYPTION(new Decrypt()),
    BRUTE_FORCE_DECRYPTION(new BruteForceDecrypt());
//    STAT_ANALYSE_DECRYPTION("STAT_ANALYSE_DECRYPTION");

    private final doAction action;
    Actions(doAction action) {
        this.action = action;
    }

    public doAction getAction(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }

}
