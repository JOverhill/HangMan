import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

       
       WordList sanat = new WordList("words.txt");
       if (sanat.getError() != null) {
        System.out.println(sanat.getError());
       }
       
    //   for(String s : sanat.giveWords()) {
    //    System.out.println(s);
    //}

    Hangman test = new Hangman(sanat, 5);
    //System.out.println(test.word().length());
    //System.out.println(test.guesses());
    //System.out.println(sanat.theWordsWithCharacters("ger_iili").giveWords());
        
    

    Scanner sc = new Scanner(System.in);
    while (test.theEnd() == false) {
        System.out.println("The hidden word...\n");
        for (int i = 0; i < test.word().length(); i++) {
            if(test.guesses().contains(test.word().charAt(i))) {
                System.out.print(test.word().charAt(i));
            }
            else {
                System.out.print("*" + " ");
            }
        }  
        System.out.println("\nGuesses left: " + test.guessesLeft());
        System.out.println("Guessed letters: " + test.guesses());
        System.out.print("Guess a letter: ");
        String arvausString = sc.nextLine();
        Character arvaus = arvausString.toLowerCase().charAt(0);
        test.guess(arvaus);
        System.out.println(test.theEnd());
        if (test.guessesLeft() == 0) {
            System.out.println("Sorry, you lost!");
            System.out.println("The hidden word was: " + test.word());
            break;
        }
        System.out.println();

    }
    if (test.guessesLeft() > 0) {
        System.out.println("Congratulations! You won!!!");
        System.out.println("The hidden word was: " + test.word());
    }
    System.out.println(test.theEnd());
    sc.close();
    }

    
} 

