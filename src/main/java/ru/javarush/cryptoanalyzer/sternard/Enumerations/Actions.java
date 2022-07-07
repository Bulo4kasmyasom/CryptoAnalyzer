package ru.javarush.cryptoanalyzer.sternard.Enumerations;

public enum Actions {
    ENCRYPTION("ENCRYPTION"),
    KEY_DECRYPTION("KEY_DECRYPTION"),
    BRUTE_FORCE_DECRYPTION("BRUTE_FORCE_DECRYPTION"),
    STAT_ANALYSE_DECRYPTION("STAT_ANALYSE_DECRYPTION");

    private final String action;
    Actions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
