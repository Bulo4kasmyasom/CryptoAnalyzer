package ru.javarush.cryptoanalyzer.sternard.console;

import ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors;
import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.*;

public abstract class ConsoleMenu {
    protected final Scanner scanner;
    public ConsoleMenu(Scanner scanner) {
        this.scanner = scanner;
    }
    public void showMenu() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "-".repeat(20) + ConsoleColors.RESET);
        System.out.printf(ConsoleColors.BLUE_BOLD_BRIGHT + "%s\n" + ConsoleColors.RESET + "%s\n%s\n%s\n", "Select the mode: ",
         ConsoleColors.BLUE_BOLD_BRIGHT + "1" + ConsoleColors.RESET + ConsoleColors.BLUE +ENCRYPT_WITH_KEY + ConsoleColors.RESET,
         ConsoleColors.BLUE_BOLD_BRIGHT + "2" + ConsoleColors.RESET + ConsoleColors.BLUE + DECRYPT_WITH_KEY + ConsoleColors.RESET,
         ConsoleColors.BLUE_BOLD_BRIGHT + "3" + ConsoleColors.RESET + ConsoleColors.BLUE + BRUTE_FORCE_DECRYPTION + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "-".repeat(20) + ConsoleColors.RESET);
    }

    public abstract String[] returnParamsFromMenu();
    protected abstract String menuGetAction();
    protected abstract String menuGetSourceFileName();
    protected abstract String menuGetDestinationFileName();
    protected abstract String menuGetKey();
}