Settings:
src/main/java/ru/javarush/cryptoanalyzer/sternard/constant/Settings.java

Launch parameters ( examples ):

ENCRYPTION source.txt encrypted.txt 12
KEY_DECRYPTION encrypted.txt decrypted.txt 12
BRUTE_FORCE_DECRYPTION encrypted.txt decrypted.txt
STAT_ANALYSE_DECRYPTION encrypted.txt decrypted.txt

Пометка на будущее:
Методы returnExecute(...) в пакете actions и классах Encrypt|Decrypt одинаковые, отличие только в
возвращаемом тексте и всё. Пробовал эти методы вырезать и вставлять в интерфейс doAction как метод по
умолчанию returnExecute(...). Но тогда переставало писать в файл и выводит один и тот же текст как результат.
Стоит ли пробовать объединять этот метод...