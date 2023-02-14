// class - always public 
public class WordMatch {
    // instance variable - always private
    // different from class variable
    private String secret;

    // constructor - always public
    public WordMatch(String word) {
        // this: refers to current object
        this.secret = word;
    }

    /*
    precondition: 0 < guess.length() <= secret.length()
    
    scoreGuess finds:
      number of times that guess occurs as a substring of secret
      * square of the length of guess
      
    Occurrences of guess may overlap within secret.
    */  
    public int scoreGuess(String guess) {
        // implement in part a)
        return 0;
    }

        /*
        returns the better guess with higher score
        if same score, alphabetically later is returned.
         */
    public String findBetterGuess(String guess1, String guess2) {
        // implement in part b)
        return guess1;
    }
}
