import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class WordList {

    private List<String> words = new ArrayList<>();
    private String errormsg;
    public WordList() {

    }
    public WordList(String filename) {
        if (filename != null) {
            try (BufferedReader teksti = new BufferedReader(new FileReader(filename))) {
                String rivi;
                while ((rivi = teksti.readLine()) != null) {
                    words.add(rivi.toLowerCase());
                }
            } catch (FileNotFoundException e) {
               this.errormsg = e.toString();
               //System.out.println(e);
            } catch (IOException e) {
                this.errormsg = e.toString();
                //System.out.println(e);
            }
        }
        
    }

    public List<String> giveWords() {
        return words;
    }
    public String getError() {
        return errormsg;
    }

    public WordList theWordsOfLength(int length) {
        WordList uusi = new WordList();
        
        for (String s : this.words) {
            if (s.length() <= length) {
                uusi.words.add(s);
            }
            
        }
        return uusi;
    }

    public WordList theWordsWithCharacters (String someString) {
        WordList uusi = new WordList();
        someString = someString.toLowerCase();
        
        for (int i = 0; i < words.size(); i++) {
            if(someString.length() == words.get(i).length()) {

            for (int j = 0; j < someString.length(); j++) {
                if (Character.isLetter(someString.charAt(j))) {
                    if (someString.charAt(j) == words.get(i).charAt(j)) {
                        if (!uusi.words.contains(words.get(i)))  {
                            uusi.words.add(words.get(i));
                        }  
                        
                        
                    }
                }
                
             }
            }

        }
        return uusi;
    }
    
    
    public List<String> getWords() {
        return words;
    }
}
