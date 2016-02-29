/**
 * 
 */
package model;

/**
 * @author mrcooper
 *
 */
public class GameLogic {
	GameNumber guesses,target;
	GameMessage msg;
	
	public GameLogic(){
		msg = new GameMessage();
		System.out.println("HI empty");
	}
	
	public GameLogic(GameNumber target){
		msg = new GameMessage();
		System.out.println("HI with target and guess");
	}
	
	private boolean checkGuess(GameNumber guess){
		// compare the guess with the target
		   if( guess.getValue() == target.getValue() ){
			   // winner
			   msg.setMessage("Correct! You got it in " + guesses.getValue() + " guesses.");
			   //resetGame();
			   return true;
		   } else {
			   // next guess
			   this.guesses.increment();
			   if ( guess.getValue() < target.getValue() ) {
				   //low
				   msg.setMessage("Incorrect guess! Guess higher next time.");
			   } else {
				   // high
				   msg.setMessage("Incorrect guess! Guess lower next time.");
			   }
			   return false;
		   }
	}

}
