/**
 * Work With Words
 */

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

class WorkWithWords {
    ArrayList<String> wordsDictionary = new ArrayList<>();
    int maxWordLenght = 10;
    int minWordLenght = 5;
    String guessedTheWord = "";
    //    read words from file
    void readWordsFromFile() {
        String workDir = "src";
        String fileNameDictionaryWords = "WordsDictionary.txt";
        String readedString = "а";
        try {
            File file = new File(String.valueOf(Paths.get(workDir, fileNameDictionaryWords).toFile()));
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
    //    читаю строки в цикле
            while ((readedString = reader.readLine()) != null) {
                readedString = readedString.toLowerCase();
                readedString = wordsFiltering(readedString);
                if (!(readedString == "")) {
                    wordsDictionary.add(readedString);
                }
            }
            reader.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String wordsFiltering(String wordsRawDictionary) {
    //   сколько слов в строке?
        String[] words = wordsRawDictionary.split(" ");
        if (words.length > 1) {
            System.out.println("В строке словаря обнаружено более одного слова. Обработаю только первое слово: " + words[0]
                    + ". Остальные слова в строке будут отброшены.");
        }
        String firstWord = words[0];
    //    обработка слова (менее 5 или более 10  букв отбросить)
        if ((firstWord.length() < minWordLenght) || (firstWord.length() > maxWordLenght)) {
            System.out.println("Слово: " + firstWord
                    + " - не подходит под диапазон от 5 до 10 букв. И было отброшено.");
            return firstWord = "";
        }
    //    проверка - слово содержит только русские буквы ?
        char tempChap;
        for (int i = 0; i < firstWord.length(); i++) {
            tempChap = firstWord.charAt(i);
            if (!(tempChap >= 'а' && tempChap <= 'я')) {
                if (tempChap == 'ё') {
                    continue;
                } else {
                    System.out.println("Слово: " + firstWord + " содержит недопустимые символы и было отброшено ");
                    return firstWord = "";
                  }
            }
        }
        return firstWord;
    }
    void guessTheWord() {
        Random numbersRandom = new Random();
        while (guessedTheWord=="") {
            int randomInteger = numbersRandom.nextInt(wordsDictionary.size());                                                      // random int
            guessedTheWord = wordsDictionary.get(randomInteger);
        }
    }
    boolean isCharInGuessWord(char ch) {
        for (int i = 0; i < guessedTheWord.length(); i++) {
            if (ch == guessedTheWord.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    String getGuessedTheWord() {
        return guessedTheWord;
    }

public static void main(String[] args) {
    WorkWithWords wordwork = new WorkWithWords();
    wordwork.readWordsFromFile();
    for (String st : wordwork.wordsDictionary) {
        System.out.println(st);
    }
    wordwork.guessTheWord();
    System.out.print("     Загаданно слово: ");
    System.out.println(wordwork.guessedTheWord);
    char y = 'б';
    System.out.println("есть ли символ в загаданном слове? "
            + wordwork.isCharInGuessWord(y));
 }
} //EoClass
