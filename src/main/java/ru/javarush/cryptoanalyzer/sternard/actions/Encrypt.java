package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.result.Result;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.*;
import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.*;

public class Encrypt extends EncryptDecrypt {

    public void resultEncryptDecrypt(int j, int key) {
        textOut.append(ALPHABET[((j + key) % ALPHABET_LENGTH)]);
    }

    @Override
    public Result returnExecute(String[] params) {
        String fileName1 = params[1];
        String fileName2 = params[2];
        int key = Integer.parseInt(params[3]);
        ReaderWriter readerWriter = new ReaderWriter();
        String text = doEncryptDecrypt(readerWriter.reader(fileName1), key);
        if(readerWriter.writer(fileName2, text))
            return new Result(ResultCode.OK, ENCRYPTED);
        else
            return new Result(ResultCode.FAILED, NOT_ENCRYPTED);
    }

}
