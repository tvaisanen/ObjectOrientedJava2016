/**
 * Created by tvaisanen on 17.5.2016.
 */
public class HangingManMain {

    static View UI;
    static WordList wl;
    static HanginMan hm;
    static Input in = new Input();



    public static void selectUI(HanginMan hm){
        System.out.println("Choose your user interface!\n[1] commandline\n[2] graphical\n");
        switch(in.readInt()){
            case 1: startGameInCommandLine(hm);
                    break;
            case 2: startGameInGui(hm);
                    break;
            default:
                    System.out.println("invalid input.. starting game in commandline!");
        }
    }

    public static void printWelcome() {
        System.out.println("Hangman 0.01 - Commandline User Interface");
    }

    public static HanginMan setHangingMan(WordList wordList){
        System.out.println("Set options for the game");
        System.out.print("number of guesses: ");
        return new HanginMan(wl, in.readInt());
    }

    public static void startGameInCommandLine(HanginMan hm){
        printWelcome();
        while(hm.guessesLeft() > 0 && !hm.gameEnded()){
            hm.showAndUpdateStatus();
            System.out.print("Input your quess: ");
            //chr = in.readChar();
            String guessAsString = in.readString();
            if (guessAsString.length() > 1){
                hm.guessWord(guessAsString);
            } else {
                hm.guess(guessAsString.charAt(0));
            }
            if(hm.gameEnded()){

                break;
            }
        }

    }

    public static void startGameInGui(HanginMan hm){
        View gui = new View(hm);
    }

    public static void charBuild(String chars, WordList wordList){
        // strings to arrays
        char[] charsToCompare = chars.toCharArray();
        for (String word : wordList.words){
            boolean lastChar = false;
            char[] comparingTo = word.toCharArray();
            // compare query string with every word in wordlist
            if (charsToCompare.length == comparingTo.length)
                for (int i = 0; i < chars.length(); i++){
                    if (i == comparingTo.length){
                        lastChar = true;
                    }
                    if (charsToCompare[i] == '_'){
                        if (lastChar){
                            //add word
                        }
                        continue;
                    } else if (charsToCompare[i] == comparingTo[i]){
                        if (lastChar){
                            //add word
                        }
                        continue;
                    } else {
                        // if the chars don't match move on to the next word
                        break;
                    }
                }
        }
    }

    public static void main(String[] args){

        wl = new WordList("words.txt");
        hm = setHangingMan(wl);
        selectUI(hm);

    }
}
