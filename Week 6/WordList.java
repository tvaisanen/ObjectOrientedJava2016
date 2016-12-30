import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordList {

    List<String> words;

    private WordList(List<String> newWords){
        words = newWords;
    }

    public WordList(String filename){
        words = new ArrayList<>();
        loadWordList(filename);

    }

    private  void loadWordList(String filename) {
        Path p = Paths.get("");
        String filepath = p.toAbsolutePath().toString() + "/" + filename;
        String line;

        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                words.add(line.toLowerCase());
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> getWords(){
        return words;
    }

    public WordList wordWithCharacters(String str){
        // strings to arrays
        // System.out.println("comparing str: " + str + " to: ");
        char[] charsToCompare = str.toCharArray();
        ArrayList<String> wordsFound = new ArrayList<>();
        System.out.println(words);
        for (String word : words){

            boolean lastChar = false;
            char[] comparingTo = word.toCharArray();
            // compare query string with every word in wordlist


            if (charsToCompare.length == comparingTo.length) {
                for (int i = 0; i < comparingTo.length; i++) {
                    // System.out.println(charsToCompare[i] + " : " + comparingTo[i]);
                    if ((i+1) == comparingTo.length) {
                        lastChar = true;
                    }
                    // System.out.println("i: " + i + " len: " + comparingTo.length + " lc: " + lastChar);
                    if (charsToCompare[i] == '_') {
                        if (lastChar) {
                            wordsFound.add(word);
                        }
                        continue;
                    } else if (charsToCompare[i] == comparingTo[i]) {
                        if (lastChar) {
                            wordsFound.add(word);
                        }
                        continue;
                    } else {
                        // if the chars don't match move on to the next word
                        break;
                    }
                }
            }
        }
        return new WordList(wordsFound);
    }

    public String getRandomWord(){
        Random r = new Random();
        return words.get(r.nextInt(getWordCount()));
    }

    public void printWords(){
        for (String word : words){
            System.out.println(word);
        }
    }

    public void addWordToList(String word){
        words.add(word);
    }

    public int getWordCount(){
        return words.size();
    }

}
