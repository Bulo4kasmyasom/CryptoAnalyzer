package ru.javarush.cryptoanalyzer.sternard;

import ru.javarush.cryptoanalyzer.sternard.controller.Controller;
import ru.javarush.cryptoanalyzer.sternard.result.ResultCode;
import ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors;

import static ru.javarush.cryptoanalyzer.sternard.constant.LangConstantsENG.WRONG_PARAMETERS;

public class Runner {

    // ENCRYPTION source.txt encrypted.txt 55
    // KEY_DECRYPTION encrypted.txt decrypted.txt 55
    // BRUTE_FORCE_DECRYPTION encrypted.txt decrypted.txt
    // STAT_ANALYSE_DECRYPTION encrypted.txt decrypted.txt

    public static void main(String[] args) {
        if (args.length > 0 && args.length <= 4) {
//            String[] xxx = {"ENCRYPTION", "source.txt", "encrypted.txt", "22"}; // for tests

//            String[] xxx = {"KEY_DECRYPTION", "encrypted.txt", "decrypted.txt", "22"}; // for tests

            String[] xxx = {"BRUTE_FORCE_DECRYPTION", "encrypted.txt", "decrypted.txt"}; // for tests


            Controller controller = new Controller();
            if (controller.checkParameters(xxx) == ResultCode.ERROR) {
                System.out.println(ConsoleColors.RED_BRIGHT + WRONG_PARAMETERS + ConsoleColors.RESET);
                return;
            }
            System.out.println(controller.execute(xxx));
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