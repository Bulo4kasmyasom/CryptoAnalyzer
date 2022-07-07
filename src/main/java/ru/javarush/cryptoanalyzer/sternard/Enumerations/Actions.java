package ru.javarush.cryptoanalyzer.sternard.Enumerations;

public enum Actions {
    ENCRYPTION("encryption"),
    KEY_DECRYPTION("key_decryption"),
    BRUTE_FORCE_DECRYPTION("brute_force"),
    STAT_ANALYSE_DECRYPTION("statistic_analyse");

    private final String action;
    Actions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
