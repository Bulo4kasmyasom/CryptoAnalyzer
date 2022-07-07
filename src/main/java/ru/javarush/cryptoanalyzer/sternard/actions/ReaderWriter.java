package ru.javarush.cryptoanalyzer.sternard.actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderWriter {

public String Reader(String[] params)
{
    StringBuilder str = new StringBuilder();
        Path path = Path.of("C:\\Users\\User\\IdeaProjects\\CryptoAnalyzer\\src\\main\\java\\ru\\javarush\\cryptoanalyzer\\sternard\\text\\source.txt");
        if(Files.exists(path)) {
            try (BufferedReader buff = new BufferedReader(new FileReader(path.toFile()))) {
                Encrypt encrypt = new Encrypt();

                while (buff.ready())
                {
                    str.append((char) buff.read());
                }
                return encrypt.Encryption(str.toString(),1);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Нет такого файла!");
        }
    return null;
}




}
