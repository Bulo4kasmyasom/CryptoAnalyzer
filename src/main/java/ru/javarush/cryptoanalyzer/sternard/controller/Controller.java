package ru.javarush.cryptoanalyzer.sternard.controller;

import ru.javarush.cryptoanalyzer.sternard.Enumerations.Actions;
import ru.javarush.cryptoanalyzer.sternard.actions.Decrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.Encrypt;
import ru.javarush.cryptoanalyzer.sternard.actions.ReaderWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public String[] checkParameters(String[] params) {
        Pattern pattern = Pattern.compile(
                "(^(" + Actions.ENCRYPTION.getAction() + "|" + Actions.KEY_DECRYPTION.getAction() + ")\\s\\w+\\.txt\\s\\w+\\.txt\\s\\d{1,2}$)|" +
                      "(^(" + Actions.BRUTE_FORCE_DECRYPTION.getAction() + "|" + Actions.STAT_ANALYSE_DECRYPTION + ")\\s\\w+\\.txt\\s\\w+\\.txt$)");
        Matcher matcher = pattern.matcher(String.join(" ", params));
        return (matcher.find()) ? matcher.group().split(" ") : null;
    }

    public boolean execute(String[] params) {
        ReaderWriter readerWriter = new ReaderWriter();
        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();

        String action = params[0];
        String pathToFile1 = params[1];
        String pathToFile2 = params[2]; // нужно дописать запись преобразованного текста
        int key = Integer.parseInt(params[3]);
        String text = "";
        boolean result = false;

        if (action.equals(Actions.ENCRYPTION.getAction())) {

            text = encrypt.encryption(readerWriter.reader(pathToFile1), key);
            result = readerWriter.writer(pathToFile2, text);

        } else if (action.equals(Actions.KEY_DECRYPTION.getAction())) {

            text = decrypt.decryption(readerWriter.reader(pathToFile1), key);
            result = readerWriter.writer(pathToFile2, text);

        } else if (action.equals(Actions.BRUTE_FORCE_DECRYPTION.getAction())) {
            text = "Брутфорс в разработке";
        } else if (action.equals(Actions.STAT_ANALYSE_DECRYPTION.getAction())) {
            text = "Статистический анализ в разработке";
        }

        return result;

    }

//    public boolean execute(String[] params) {
//        chooseAction(params);
//
//        return false;
//    }

}
