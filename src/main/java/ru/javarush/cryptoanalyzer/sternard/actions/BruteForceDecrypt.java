package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.controller.ReaderWriter;
import ru.javarush.cryptoanalyzer.sternard.controller.doAction;
import ru.javarush.cryptoanalyzer.sternard.result.*;
import ru.javarush.cryptoanalyzer.sternard.util.PathFinder;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET_LENGTH;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.NOT_DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.util.PathFinder.getTextDirectory;

public class BruteForceDecrypt implements doAction {

    @Override
    public Result returnExecute(String[] params) {
        String fileName1 = params[1];
        String fileName2 = params[2];
        int key = 0;

        while (key < ALPHABET_LENGTH) {

            ReaderWriter readerWriter = new ReaderWriter();
            Decrypt decrypt = new Decrypt();

            String text = decrypt.doEncryptDecrypt(
                    readerWriter.reader(PathFinder.getTextDirectory() + fileName1), key);

            long countOfSymbols = text.chars().filter(ch -> ch == ' ').count();
            long textLength = text.length();

            if (countOfSymbols > textLength / 10) {
                readerWriter.writer(getTextDirectory() + fileName2, text, false);
                return new Result(ResultCode.OK, DECRYPTED);
            }
            key++;
        }
        return new Result(ResultCode.FAILED, NOT_DECRYPTED);
    }
}
