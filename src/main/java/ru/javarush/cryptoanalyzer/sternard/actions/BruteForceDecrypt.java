package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET_LENGTH;
import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.NOT_DECRYPTED;

public class BruteForceDecrypt implements doAction {

    @Override
    public Result returnExecute(String[] params) {
        String fileName1 = params[1];
        String fileName2 = params[2];
        int key = 0;

        while (key < ALPHABET_LENGTH) {

            ReaderWriter readerWriter = new ReaderWriter();
            Decrypt decrypt = new Decrypt();

            String text = decrypt.doEncryptDecrypt(readerWriter.reader(fileName1), key);

            long countOfSymbols = text.chars().filter(ch -> ch == ' ').count();
            long textLength = text.length();

            if (countOfSymbols > textLength / 10) {
                readerWriter.writer(fileName2, text);
                return new Result(ResultCode.OK, DECRYPTED);
            }
            key++;
        }
        return new Result(ResultCode.FAILED, NOT_DECRYPTED);
    }
}
