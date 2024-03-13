/**
 * Draws an object"Handman" using ASCII characters.
 */

import java.util.ArrayList;
import java.util.Arrays;

class ASCIIDrawning {
    ArrayList<String> artList = new ArrayList<String>(
            Arrays.asList(
                    " ____",
                    " |  |",
                    " |  ",
                    " |  ",
                    " |  ",
                    " |  ",
                    "/|" + "\\"));

    void printHangman(int unsuccessfulAttempts) {
        if (unsuccessfulAttempts > 6) {
            System.out.println("Количество ошибок равно " + unsuccessfulAttempts +
                               " печать виселицы невозможна!");
            return;
        }
        switch (unsuccessfulAttempts) {
            case 0:
                break;
            case 1:
                artList.set(2, " |  o");
                break;
            case 2:
                artList.set(3, " |  |");
                break;
            case 3:
                artList.set(3, " | /|");
                break;
            case 4:
                artList.set(3, " | /|\\");
                break;
            case 5:
                artList.set(4, " | /`");
                break;
            case 6:
                artList.set(4, " | /`\\");
                    break;
            default:
                break;
            }
        for (String c : artList ) {
            System.out.println(c);
        }
    }

//    public static void main(String[] args) {
//        ASCIIDrawning draw = new ASCIIDrawning();
//        draw.printHangman(0);
//        draw.printHangman(1);
//        draw.printHangman(2);
//        draw.printHangman(3);
//        draw.printHangman(4);
//        draw.printHangman(5);
//        draw.printHangman(6);
//        draw.printHangman(7);
//    }
}
