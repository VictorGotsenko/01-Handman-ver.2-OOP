/**
 * Main module
 */

import java.util.ArrayList;

public class HandmanMain {
    ArrayList<Character> charsOpenInGuessWord = new ArrayList<>();

    public static void main(String[] args) {
        WorkWithWords workWithWords = new WorkWithWords();
        GameLogic gameLogic = new GameLogic();
        ASCIIDrawning asciiDrawning = new ASCIIDrawning();
        gameLogic.welcomeInGame();
        gameLogic.inviteGame();
        workWithWords.readWordsFromFile();
        // начало игрового цикла: загадай слово
        workWithWords.guessTheWord();
        gameLogic.fillCollectionWithMask(workWithWords.getGuessedTheWord());
        gameLogic.printCollectionWithMask();

        int unsuccessfulAttempts = 0;
        asciiDrawning.printHangman(unsuccessfulAttempts);
        while (unsuccessfulAttempts < 6) {
            if (!workWithWords.isCharInGuessWord(gameLogic.getCharFromKeyboard())) {
                unsuccessfulAttempts++;
            }
            asciiDrawning.printHangman(unsuccessfulAttempts);
        }
    }
}
