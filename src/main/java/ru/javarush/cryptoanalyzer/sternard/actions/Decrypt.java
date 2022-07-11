package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.controller.EncryptDecrypt;
import ru.javarush.cryptoanalyzer.sternard.controller.ReaderWriter;
import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;
import ru.javarush.cryptoanalyzer.sternard.util.PathFinder;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.*;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.NOT_DECRYPTED;
import static ru.javarush.cryptoanalyzer.sternard.util.PathFinder.getTextDirectory;

public class Decrypt extends EncryptDecrypt {
    public void resultEncryptDecrypt(int j, int key) {
        textOut.append(ALPHABET[((j - key) + ALPHABET_LENGTH) % ALPHABET_LENGTH]);
    }

    @Override
    public Result returnExecute(String[] params) {
        String fileName1 = params[1];
        String fileName2 = params[2];
        int key = Integer.parseInt(params[3]);
        ReaderWriter readerWriter = new ReaderWriter();
        String text = doEncryptDecrypt(
                readerWriter.reader(PathFinder.getTextDirectory() + fileName1), key);

        if (readerWriter.writer(getTextDirectory() + fileName2, text, false))
            return new Result(ResultCode.OK, DECRYPTED);
        else
            return new Result(ResultCode.FAILED, NOT_DECRYPTED);
    }
}
