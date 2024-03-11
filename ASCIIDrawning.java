import java.util.ArrayList;
import java.util.Arrays;

/**
 * Draws an object"Handman" using ASCII characters.
 */
public class ASCIIDrawning {
    ArrayList<String> artList = new ArrayList<String>(Arrays.asList(
            " ____",
            " |  |",
            " |  ",
            " |  ",
            " |  ",
            " |  ",
            "/|" + "\\"));

    void printHangman(int iError) {
        if (iError > 6) {
            System.out.println("Количество ошибок равно " + iError + " печать виселицы невозможна!");
            return;
        }
        switch (iError) {
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

        // вывод с использованием синтаксиса foreach если не нужны индексы элементов
        for (String c : artList ) {
            System.out.println(c);
        }
    }

//    public static void main(String[] args) {
//        ASCIIDrawning draw = new ASCIIDrawning();
//        draw.printHangman(0);
//    }
}
