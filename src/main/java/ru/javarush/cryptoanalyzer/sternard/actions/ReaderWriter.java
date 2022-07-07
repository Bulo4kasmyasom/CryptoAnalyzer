package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.exceptions.ActionsParamsExceptions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderWriter {

    public String reader(String pathToFile) {
        StringBuilder text = new StringBuilder();
        Path path = Path.of(pathToFile);
        if (Files.exists(path)) {
            try (BufferedReader buff = new BufferedReader(new FileReader(path.toFile()))) {
                while (buff.ready()) {
                    text.append((char) buff.read());
                }
                return text.toString();
            } catch (IOException e) {
                throw new ActionsParamsExceptions("File reading error");
            }
        } else {
            System.out.println("File reading error, perhaps such a file does not exist?");
        }
        return text.toString();
    }


    public boolean writer(String pathToFile, String text) {
        Path path = Path.of(pathToFile);
        if(Files.notExists(path))
        {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new ActionsParamsExceptions("Cannot create file");
            }
        }
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(pathToFile, false))) {
            buff.write(text);
        } catch (IOException e) {
            throw new ActionsParamsExceptions("File writing error");
        }
        return true;
    }
}
