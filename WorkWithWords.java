import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Work With Words
 */
public class WorkWithWords {
    // read words from file
    ArrayList<String> readWordsFromFile() {
        String sWorkDir = "src";
        String sWordsDictionary = "WordsDictionary.txt";
        String sTmpString = "а";
        ArrayList<String> wordsRawDictionary = new ArrayList<>();
        try {
            File file = new File(String.valueOf(Paths.get(sWorkDir, sWordsDictionary).toFile()));
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            while ((sTmpString = reader.readLine()) != null) {                                                          // считываем строки в цикле
                sTmpString = sTmpString.toLowerCase();
                wordsRawDictionary.add(sTmpString);
            }
            reader.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsRawDictionary;
    }

}
