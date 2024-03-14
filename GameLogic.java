import java.util.ArrayList;
import java.util.Scanner;

/**
 * Task04(GameLogicClass) on 13.03.2024.
 */
class GameLogic {
    ArrayList<Character> charsGuessWord = new ArrayList<>();
    Scanner cReadFromKeyboard = new Scanner(System.in);
    void welcomeInGame() {
        System.out.println(" Добро пожаловать в игру Виселица");
    }
    boolean inviteGame() {
        boolean isGaming = false;
        String tempReadFromKeyboadr;
        char choseKey = 2;
        System.out.println("Начать игру нажмите 1 / Для Выхода нажмите 2");
        while (choseKey != '1') {
            tempReadFromKeyboadr = cReadFromKeyboard.nextLine();
            choseKey = tempReadFromKeyboadr.charAt(0);
            switch (choseKey) {
                case '1':
                    System.out.println();
                    isGaming = true;
                    break;
                case '2':
                    System.out.println("Работа программы завершена. До свидания!");
                    cReadFromKeyboard.close();
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Ошибка! Пожалуйста введите 1 или 2 , а было введено: %s", choseKey);
                    System.out.println("");
            }
        }
        return isGaming;
    }

    void fillCollectionWithMask(String guessedTheWord) {
        for (int i = 0; i < guessedTheWord.length(); i++) {
            charsGuessWord.add('_');
        }
    }

    void addOpenCharInCollectionWithMask(Character openChar, String guessedTheWord) {
        for (int i = 0; i < guessedTheWord.length(); i++) {
            if (openChar == guessedTheWord.charAt(i)) {
                charsGuessWord.set(i, openChar);
            }
        }
    }

    boolean isMaskInCollectionGuessWord(ArrayList<Character> charsGuessWord) {
        if (charsGuessWord.contains('_')) {
            return true;
        }
        return false;
    }

    void printCollectionWithMask() {
        System.out.println("Загаданное слово...");
        for (Character ch : charsGuessWord) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    char getCharFromKeyboard() {
        String inputFromKeyboard = "";
        while (!inputFromKeyboard.matches("[а-я||ё]")) {
            System.out.print("Введите одну русскую букву в нижнем регистре: ");
            inputFromKeyboard = cReadFromKeyboard.nextLine();
            inputFromKeyboard = inputFromKeyboard.toLowerCase();
        }
        return inputFromKeyboard.charAt(0);
    }

    public static void main(String[] args) {
        GameLogic gp = new GameLogic();
//        gp.welcomeInGame();
//        System.out.println(gp.inviteGame());
        String stG = "мяч";
        gp.fillCollectionWithMask(stG);
        gp.printCollectionWithMask();
//        System.out.println("Input char: " + gp.getCharFromKeyboard());
        while (gp.isMaskInCollectionGuessWord(gp.charsGuessWord)) {
            gp.printCollectionWithMask();
            gp.addOpenCharInCollectionWithMask(gp.getCharFromKeyboard(),stG);
        }

    }
}//eoc
