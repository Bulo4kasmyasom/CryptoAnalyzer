package ru.javarush.cryptoanalyzer.sternard;

import ru.javarush.cryptoanalyzer.sternard.Enumerations.Actions;
import ru.javarush.cryptoanalyzer.sternard.controller.Controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET_LENGTH;
import static ru.javarush.cryptoanalyzer.sternard.constant.Errors.WRONG_PARAMETERS;

public class Runner {

    // ENCRYPTION source.txt encrypted.txt 55
    // KEY_DECRYPTION encrypted.txt decrypted.txt 55
    // BRUTE_FORCE_DECRYPTION encrypted.txt decrypted.txt
    // STAT_ANALYSE_DECRYPTION encrypted.txt decrypted.txt
    /*
         (^(ENCRYPTION|KEY_DECRYPTION)\s\w+\.txt\s\w+\.txt\s\d{1,2}$)|(^(BRUTE_FORCE_DECRYPTION|STAT_ANALYSE_DECRYPTION)\s\w+\.txt\s\w+\.txt$)
     */

    public static void main(String[] args) {
        if (args.length > 0 && args.length <= 5) {
            String[] xxx = {"ENCRYPTION", "source.txt", "encrypted.txt", "1"}; // for tests
            Controller controller = new Controller();
            if(controller.checkParameters(xxx) == null)
            {
                System.out.println(WRONG_PARAMETERS);
                return;
            }

            controller.execute(controller.checkParameters(xxx));
        }






//        System.out.println("1. Шифровка текста\n2. Расшифровка с помощью ключа\n" +
//                                 "3. Расшифровка с помощью brute force\n");
//        Scanner scan = new Scanner(System.in);
//        int menuId = scan.nextInt();
//        if (menuId == 1) {
//            System.out.println("Введите путь к файлу с исходным текстом: ");
//            String sourceFilePath  = scan.nextLine();
//        }
//        else if (menuId == 2) {
//            System.out.println("Введите путь к файлу с зашифрованным текстом: ");
//            String encryptedFilePath  = scan.nextLine();
//            System.out.println("Ключ для расшифровки от 0 до "+ ALPHABET_LENGTH +": ");
//            int key  = scan.nextInt();
//        }
//        else if (menuId == 3) {
//            System.out.println("Введите путь к файлу с зашифрованным текстом: ");
//            String encryptedFilePath  = scan.nextLine();
//        }


    }
}