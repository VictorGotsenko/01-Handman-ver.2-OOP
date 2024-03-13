import java.util.Scanner;

/**
 * Task04(GameLogicClass) on 13.03.2024.
 */
class GameLogic {
    void welcomeInGame() {
        System.out.println(" Добро пожаловать в игру Виселица");
    }
    boolean inviteGame() {
        boolean isGaming = false;
        String tempReadFromKeyboadr;
        char choseKey = 2;
        Scanner cReadFromKeyboard = new Scanner(System.in);
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

    public static void main(String[] args) {
        GameLogic gp = new GameLogic();
        gp.welcomeInGame();
        System.out.println(gp.inviteGame());

    }
}//eoc
