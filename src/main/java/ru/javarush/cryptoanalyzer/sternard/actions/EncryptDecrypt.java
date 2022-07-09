package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.exceptions.HandlerExceptions;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.*;
import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.FILE_EMPTY_ERROR;

public abstract class EncryptDecrypt implements doAction {
    StringBuilder textOut = new StringBuilder();

    public String doEncryptDecrypt(String textIn, int key) {
        if (textIn.length() > 0) {
            for (int i = 0; i < textIn.length(); i++) {
                for (int j = 0; j < ALPHABET_LENGTH; j++) {
                    if (textIn.charAt(i) == ALPHABET[j]) {
                        resultEncryptDecrypt(j, key);
                    }
                }
            }
            return textOut.toString();
        } else {
            throw new HandlerExceptions(FILE_EMPTY_ERROR);
        }
    }

    public abstract void resultEncryptDecrypt(int j, int key);
}
