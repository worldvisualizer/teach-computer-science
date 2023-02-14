// import java.lang.Math;

// class - always public 
public class WordMatchDone {
    // instance variable - always private
    // different from class variable
    private String secret;

    // constructor - always public
    public WordMatchDone(String word) {
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

        int count = 0;
        // str.indexOf(String other): returns index of other
        for (int i = 0; i < this.secret.length(); i++) {
            String copyOfSecret = this.secret.substring(i, this.secret.length());
            if (copyOfSecret.indexOf(guess) != -1) {
                count++;
            }  
        }

        // another way
        // Object.equals(Object other): returns if two objects are equal
        count = 0;
        for (int i = 0; i <= this.secret.length() - guess.length(); i++) {
            if (this.secret.substring(i, i + guess.length()).equals(guess))
                count++;
        }

        // using typecasting might be out of the scope of AP exam
        // return count * (int) Math.pow(guess.length(), 2.0);
        return count * guess.length() * guess.length();
    }

        /*
        returns the better guess with higher score
        if same score, alphabetically later is returned.
         */
    public String findBetterGuess(String guess1, String guess2) {
        // implement in part b)

        int score1 = this.scoreGuess(guess1);
        int score2 = this.scoreGuess(guess2);
        if (score1 > score2)
            return guess1;
        else if (score1 < score2)
            return guess2;
        else
            return guess1.compareTo(guess2) > 0 ? guess1 : guess2;
    }

    public static void runTestPartA(String secret, String[] guesses) {
        WordMatchDone wm = new WordMatchDone(secret);
        for (String guess : guesses) {
            int score = wm.scoreGuess(guess);
            System.out.println(
                String.format(
                    "test: secret = %s, guess = %s, score = %d",
                    secret, guess, score
                )
            );
        } 
    }

    public static void runTestPartB(
        String secret, String guess1, String guess2
    ) {
        WordMatchDone wm = new WordMatchDone(secret);
        String better = wm.findBetterGuess(guess1, guess2);
        System.out.println(
            String.format(
                "test: secret = %s, guess1 = %s, guess2 = %s, better = %s",
                secret, guess1, guess2, better)
        );
        
    }

    public static void main(String[] args) {
        // part a, test case 1
        runTestPartA(
            "mississippi",
            new String[] {"i", "iss", "issipp", "mississippi"}
        );

        // part a, test case 2
        runTestPartA(
            "aaaabb",
            new String[] {"a", "aa", "aaa", "aabb", "c"}
        );

        runTestPartB(
            "concatenation", "ten", "nation"
        );

        runTestPartB(
            "concatenation", "con", "cat"
        );
    }
}
