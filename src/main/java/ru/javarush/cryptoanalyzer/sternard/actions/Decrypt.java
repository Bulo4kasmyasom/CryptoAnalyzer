package ru.javarush.cryptoanalyzer.sternard.actions;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.*;

public class Decrypt {

    public String Decryption(String textIn, int key) {
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


}
