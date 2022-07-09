package ru.javarush.cryptoanalyzer.sternard.actions;

import ru.javarush.cryptoanalyzer.sternard.exceptions.HandlerExceptions;
import ru.javarush.cryptoanalyzer.sternard.util.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.*;

public class ReaderWriter {

    public String reader(String fileName) {
        StringBuilder text = new StringBuilder();
        Path path = Path.of(PathFinder.getRoot() + fileName);
        if (Files.exists(path)) {
            try (BufferedReader buff = new BufferedReader(new FileReader(String.valueOf(path)))) {
                while (buff.ready()) {
                    text.append((char) buff.read());
                }
                return text.toString();
            } catch (IOException e) {
                throw new HandlerExceptions(FILE_READING_ERROR);
            }
        } else {
            throw new HandlerExceptions(FILE_NOT_FOUND_ERROR);
        }
    }

    public boolean writer(String fileName, String text) {
        Path path = Path.of(PathFinder.getRoot() + fileName);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new HandlerExceptions(CREATE_FILE_ERROR);
            }
        }
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(PathFinder.getRoot() + fileName, false))) {
            buff.write(text);
        } catch (IOException e) {
            throw new HandlerExceptions(FILE_WRITING_ERROR);
        }
        return true;
    }
}
