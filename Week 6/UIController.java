/**
 * Created by tvaisanen on 25.5.2016.
 */
public class UIController {

    private HanginMan game;

    UIController(HanginMan hm) {
        game = hm;
    }

    public boolean gameEnded() {
        game.printCurrentStatus();
        if(game.guessesLeft() == 0 && game.gameEnded()){
            System.out.println("game over");
            return true;
        }
        return false;
    }

    public String getWord(){
        return game.getWordToGuess();
    }

    public boolean wordGuessed(){
        return game.getWordGuessedStatus();
    }

    public void guess(char chr){
        gameEnded();
        game.guess(chr);
        System.out.println("Guesses left: " + game.guessesLeft());
    }

    public boolean guessWord(String word){

        System.out.println("Guesses left: " + game.guessesLeft());
        boolean rightAnswer = game.guessWord(word);
        if (rightAnswer){
            return true;
        } else {
            return false;
        }
    }

    public String getGuessesLeftStatus(){
        return "Guesses left: " + (game.guessesLeft()-1);
    }

    public int getGuessesLeft(){
        return game.guessesLeft();
    }

    public String getWordStatus(){
        return game.printCurrentStateOfTheWord();
    }
}
