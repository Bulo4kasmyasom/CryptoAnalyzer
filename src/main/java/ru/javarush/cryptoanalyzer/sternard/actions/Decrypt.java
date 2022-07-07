package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.exceptions.ActionsParamsExceptions;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.*;

public class Decrypt {

    public String decryption(String textIn, int key) {
        if(textIn.length() > 0) {
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < textIn.length(); i++) {
                for (int j = 0; j < ALPHABET_LENGTH; j++) {
                    if (textIn.charAt(i) == ALPHABET[j]) {
                        out.append(ALPHABET[((j - key) + ALPHABET_LENGTH) % ALPHABET_LENGTH]);
                    }
                }
            }
            return out.toString();
        }
        else
        {
            throw new ActionsParamsExceptions("File is empty"); // нужно ли это здесь?
        }
    }


}
