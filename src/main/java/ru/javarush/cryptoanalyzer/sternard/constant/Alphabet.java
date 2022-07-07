package ru.javarush.cryptoanalyzer.sternard.constant;

public class Alphabet {
    private static final String RUS = "абвгдежзиклмнопрстуфхцчшщъыьэюя";
//    private final static String SYMBOLS = ".,«»\"':!? ";
    private static final String SYMBOLS = ",./?><'\":;][{}\\|!@#$%^&*()`~_-+= ";
    private static final String NUMBERS = "0123456789";
    private final static String ALPHABET_CONCAT = RUS + RUS.toUpperCase() + SYMBOLS + NUMBERS;
    public final static char[] ALPHABET = ALPHABET_CONCAT.toCharArray();
    public final static int ALPHABET_LENGTH = ALPHABET.length;
}