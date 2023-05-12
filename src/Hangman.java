import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Hangman {
    private int guesses = 0;
    private String sana;
    private List<Character> arvatut = new ArrayList<>();
    

    public Hangman(WordList input, int guesses) {
        
        this.guesses = guesses;
        this.sana = getRandomElement(input);
    }

    public boolean guess(Character c) {
        c = Character.toLowerCase(c);
        if(sana != null && guesses > 0) {
            if (!arvatut.contains(c)) {
                arvatut.add(c);
            }
            
            if ( sana.indexOf(c) == -1) {
                guesses -= 1;
                return false;
            } else return true;
        }
        if (guesses > 0) {
            guesses -= 1;
        }
        return false;
    }

    public List<Character> guesses() {
        return arvatut;
    }

    public int guessesLeft() {
        return guesses;
    }

    public String word(){
        return sana;
    }

    public boolean theEnd() {
        if (sana != null) {
        
        if (guesses > 0) {
            String result = sana;
        for (Character c : arvatut ) {
            result = result.replace(c.toString(), "");
        }
        if (result == null || result.trim().isEmpty()) {
            return true;
        } else return false;
    }
    else return true;
        } else return true;
       
        
    }

    public int getIndex(Character c) {
        return sana.indexOf(c);
    }
    public String getRandomElement(WordList input) {
        Random rand = new Random();
        if (!input.giveWords().isEmpty()) {
            return input.giveWords().get(rand.nextInt(input.giveWords().size()));
        }
        else return "Error";
    }
}
