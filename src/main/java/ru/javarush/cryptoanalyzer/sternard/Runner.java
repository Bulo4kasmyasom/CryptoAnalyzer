package ru.javarush.cryptoanalyzer.sternard;

import ru.javarush.cryptoanalyzer.sternard.controller.Controller;

import java.util.Arrays;
import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.sternard.constant.Alphabet.ALPHABET_LENGTH;

public class Runner {

    // ENCRYPTION source.txt encrypted.txt 55
    // KEY_DECRYPTION encrypted.txt decrypted.txt 55
    // BRUTE_FORCE_DECRYPTION encrypted.txt decrypted.txt
    // STAT_ANALYSE_DECRYPTION encrypted.txt decrypted.txt
    //
    //

    public static void main(String[] args) {
        if (args.length > 0 && args.length <= 5) {
            String action = args[0];
            String[] params = Arrays.copyOfRange(args, 1, args.length);
            Controller controller = new Controller();
            System.out.println(controller.doAction(action, params));
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