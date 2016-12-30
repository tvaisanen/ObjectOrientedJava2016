import java.util.*;

// TODO: koko sanan kerralla arvausjuttuhommma

public class HanginMan {

    private List<Character> guesses, rightGuesses, wrongGuesses;
    private String wordToGuess;
    private int numberOfGuesses;
    private int guessAmountAtStart;
    private WordList words;
    private boolean wordGuessed;
    private boolean gameEnded;
    char[] wordAsCharArray;


    public HanginMan(WordList wordList, int amountOfGuesses){
        words = wordList;
        wordToGuess = wordList.getRandomWord();
        guessAmountAtStart = amountOfGuesses;
        numberOfGuesses = amountOfGuesses;
        guesses = new ArrayList<Character>(wordToGuess.length());
        wordAsCharArray = wordToGuess.toCharArray();
        rightGuesses = new ArrayList<>();
        wrongGuesses = new ArrayList<>();
        gameEnded = false;
    }

    public boolean guess(char chr){
        chr = Character.toLowerCase(chr);
        guesses.add(chr);
        numberOfGuesses -= 1;
        String c = String.valueOf(chr);
        if (wordToGuess.contains(c)){
            rightGuesses.add(chr);
            System.out.println("Right guesses: " + rightGuesses);
            System.out.println("Wrong guesses: " + wrongGuesses);
            Collections.sort(rightGuesses);
			compareUniqueCharsInAWordToRightGuesses();
            return  true;
        } else {
            wrongGuesses.add(chr);
            System.out.println("Right guesses: " + rightGuesses);
            System.out.println("Wrong guesses: " + wrongGuesses);
            Collections.sort(wrongGuesses);
            return false;
        }
    }

    public boolean guessWord(String word){
        //System.out.println(word + " = " + wordToGuess);
        numberOfGuesses -= 1;
        if (word.equalsIgnoreCase(wordToGuess)){
            System.out.println("Right answer!");
            gameEnded = true;
            wordGuessed = true;
            return true;
        } else {
            System.out.println("Wrong answer!");
            return false;
        }
    }

    public List<Character> guesses(){
        return guesses;
    }

    public int guessesLeft(){
        return numberOfGuesses;
    }

    public String getWordToGuess(){
        return wordToGuess;
    }

    public boolean gameEnded(){
        if (numberOfGuesses == 0 || wordGuessed){
			if (wordGuessed){
				System.out.println("You won!");
            } else if (numberOfGuesses == 0){
                System.out.println("You have used all your guesses. Game over!");
            } 
            gameEnded = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HanginMan{" +
                "guesses=" + guesses +
                ", wordToGuess='" + wordToGuess + '\'' +
                ", numberOfGuesses=" + numberOfGuesses +
                ", wordList=" + words +
                ", wordGuessed=" + wordGuessed +
                '}';
    }

    public void printCurrentStatus(){
        System.out.println(toString());
    }

    public void compareUniqueCharsInAWordToRightGuesses(){

        // Todo: clean up implementation.. little messy after resolved..

        //char[] wordAsCharArray = wordToGuess.toCharArray();
        ArrayList<Character> uniqueChars = new ArrayList<>();

        for (int i = 0; i < wordAsCharArray.length; i++){
            if (!uniqueChars.contains((Character)wordAsCharArray[i])){
                uniqueChars.add(wordAsCharArray[i]);
            }

        }
        Collections.sort(uniqueChars);

        Set<Character> answerSet = new HashSet<>(uniqueChars);
        Set<Character> rightQuestionsSet = new HashSet<>(rightGuesses);
        // System.out.println(uniqueChars + " : " + rightGuesses);
        // System.out.println(uniqueChars == rightGuesses);
        if (answerSet.equals(rightQuestionsSet)){
            wordGuessed = true;
        }
    }

    public String printCurrentStateOfTheWord(){
        ArrayList<Character> query = new ArrayList<>();
        for (int i = 0; i < wordToGuess.length(); i++){
            query.add('_');
        }
        // for every character in right guesses
        // compare chars to every char in word to be quessed
        for (Character c : rightGuesses){

            for (int j = 0; j < wordToGuess.length(); j++) {

                if (c == wordAsCharArray[j]) ;
                // System.out.print("comparing: " + c + " == " + wordAsCharArray[j]);
                // System.out.println(" : " + (c == wordAsCharArray[j]));
                    if(query.get(j) == '_') {
                        if (c == wordAsCharArray[j]) {
                            query.set(j, c);
                        } else {
                            query.set(j, '_');
                        }
                    }
                    //System.out.println("query: " + query);
                    //System.out.println("WASCA: " + wordAsCharArray);
                    //query[j] = wordAsCharArray[j];
            }
        }
        String state = "";
        for (Character c : query){
            state += c;
        }
        System.out.println("what is the word: " + state + "?");
        return state;
    }

    public void showAndUpdateStatus(){
        printCurrentStateOfTheWord();
        System.out.println("Guesses left: " + guessesLeft());
        compareUniqueCharsInAWordToRightGuesses();
        if (gameEnded()){
            if (wordGuessed){
                System.out.println("Victoryyy!");
            } else {
                System.out.println("no more questions left.");
                System.out.println("YOU LOST!");
            }
        }
    }

    public void newWord(){
        wordToGuess = words.getRandomWord();
        wordGuessed = false;
        rightGuesses = null;
        wrongGuesses = null;
        numberOfGuesses = guessAmountAtStart;
    }

    public boolean getWordGuessedStatus(){
        return wordGuessed;
    }
}
