package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.exceptions.ActionsParamsExceptions;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.*;

public class Encrypt {

    public String encryption(String textIn, int key) {
        if(textIn.length() > 0) {
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < textIn.length(); i++) {
                for (int j = 0; j < ALPHABET_LENGTH; j++) {
                    if (textIn.charAt(i) == ALPHABET[j]) {
                        out.append(ALPHABET[((j + key) % ALPHABET_LENGTH)]);
                    }
                }
            }
            return out.toString();
        }
        else
        {
            throw new ActionsParamsExceptions("File is empty");
        }
    }


}
