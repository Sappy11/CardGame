import helper.TextIO;

public class CardGuess {


   public static void main(String[] args) {
   
      System.out.println("This is a simple card game, A card is dealt from a deck of cards, We have to predict whether the next card will be higher or lower.");
      System.out.println();
      
      int gamesPlayed = 0;     // Number of games user has played.
      int sumOfScores = 0;     // The sum of all the scores from 
                               //      all the games played.
      double averageScore;     // Average score, computed by dividing
                               //      sumOfScores by gamesPlayed.
      boolean playAgain;       // Record user's response when user is 
                               //   asked whether he wants to play 
                               //   another game.
      
      do {
         int scoreThisGame;        // Score for one game.
         scoreThisGame = play();   // Play the game and get the score.
         sumOfScores += scoreThisGame;
         gamesPlayed++;
         TextIO.put("Play again? ");
         playAgain = TextIO.getlnBoolean();
      } while (playAgain);
      
      averageScore = ((double)sumOfScores) / gamesPlayed;
      
      System.out.println();
      System.out.println("You played " + gamesPlayed + " games.");
      System.out.printf("Your average score was %1.3f.\n", averageScore);
      
   
   }  // end main()
   

//using constants from enum class Guess to check if user predicted the guess correct or wrong.
private static void checkGuess(Guess guess) {

		   
		   switch(guess) {
		   
		   case CORRECT:
			   TextIO.putln("Your prediction was correct.");
			   break;
		   case INCORRECT:
			   TextIO.putln("Your prediction was incorrect.");
			   break;
		   case TIE:
			    TextIO.putln("The value is the same as the previous card.");
	            TextIO.putln("You lose on ties.  Sorry!");
	            break;
			   
		default:
			break;
			  
		   
	   }
	
}
   

  
   private static int play() {
   
      Deck deck = new Deck();  // Get a new deck of cards, and 
                               //   store a reference to it in 
                               //   the variable, deck.
      
      Card currentCard;  // The current card, which the user sees.

      Card nextCard;   // The next card in the deck.  The user tries
                       //    to predict whether this is higher or lower
                       //    than the current card.

      int correctGuesses ;  // The number of correct predictions the
                            //   user has made.  At the end of the game,
                            //   this will be the user's score.

      char guess;   // The user's guess.  'H' if the user predicts that
                    //   the next card will be higher, 'L' if the user
                    //   predicts that it will be lower.
      
      //Calling the shuffle method from Deck class, An OOP concept of cohesion is used here.
      deck.shuffle();  // Shuffle the deck into a random order before starting the game.
    
                        

      correctGuesses = 0;
      currentCard = deck.dealCard();
      
      
    //using a system helper class (TextIO) to print on console, An OOP concept of Delegation is used here.
      
      TextIO.putln("The first card is the " + currentCard); 
      while (true) {  // Loop ends when user's prediction is wrong.
         
         /* Get the user's prediction, 'H' or 'L' (or 'h' or 'l'). */
         
         TextIO.put("Will the next card be higher (H) or lower (L)?  ");
         do {
             guess = TextIO.getlnChar();
             guess = Character.toUpperCase(guess);
             if (guess != 'H' && guess != 'L') 
                TextIO.put("Please respond with H or L:  ");
         } while (guess != 'H' && guess != 'L');
         
         /* Get the next card and show it to the user. */
         
         nextCard = deck.dealCard();
         TextIO.putln("The next card is " + nextCard);
         
         /* Check the user's prediction. */
         
         if (nextCard.getValue() == currentCard.getValue()) {
        	 checkGuess(Guess.TIE);
            break;  // End the game.
         }
         else if (nextCard.getValue() > currentCard.getValue()) {
            if (guess == 'H') {
               checkGuess(Guess.CORRECT);
                correctGuesses++;
            }
            else {
            	checkGuess(Guess.INCORRECT);
                break;  // End the game.
            }
         }
         else {  // nextCard is lower
            if (guess == 'L') {
            	checkGuess(Guess.CORRECT);
                correctGuesses++;
            }
            else {
            	checkGuess(Guess.INCORRECT);
              
                break;  // End the game.
            }
         }
         
      
         
         currentCard = nextCard;
         TextIO.putln();
         TextIO.putln("The card is " + currentCard);
         
      } // end of while loop
      
      TextIO.putln();
      TextIO.putln("The game is over.");
      TextIO.putln("You made " + correctGuesses 
                                           + " correct predictions.");
      TextIO.putln();
      
      return correctGuesses;
      
   }  // end play()





   

} // end class
