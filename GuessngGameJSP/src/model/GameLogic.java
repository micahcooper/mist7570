/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author micah cooper
 *
 */
public class GameLogic implements Serializable{
	private static final long serialVersionUID = 1L;
	GameNumber guesses,target;
	GameMessage msg;
	int maximum, minimum;
	HashMap<Integer, Double> averages; 
	
	public GameLogic(){
		//constructor to setup a new gameLogic object without a random number
		msg = new GameMessage();
		target = new GameNumber();
		guesses = new GameNumber(1);
		//System.out.println("New game logic started");
	}
	
	public GameLogic(int minimum, int maximum){
		//constructor to setup a gameLogic with a random number
		this.maximum=minimum;
		this.maximum=maximum;
		msg = new GameMessage();
		target = new GameNumber();
		guesses = new GameNumber(1);
		target.setRandom(minimum, maximum);
		//System.out.println("New game logic started with min/max");
	}
	
	public boolean checkGuess(GameNumber guess){
		System.out.println("Lets play a game (checkGuess), target:" + target.getValue()+", guesses: "+guesses.getValue() );
		// compare the guess with the target
		   if( guess.getValue() == target.getValue() ){
			   // winner
			   msg.setCorrectMessage("Correct! You got it in " + guesses.getValue() + " guesses.");
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
			   System.out.println("Finished game (checkGuess)");
			   return false;
		   }
	}
	
	/**
	 * resets the game: new target number, flip newGame flag
	 */
	public void resetGame(){
		System.out.println("Reset game min:"+minimum+" max:"+maximum);
		//reset the target, set guesses to 1, and newGame flag to true
		target.setRandom(minimum, maximum, "reset game");
		this.msg.setMessage("");
		this.guesses.setValue(1);
		
	}

	public GameNumber getGuesses() {
		return guesses;
	}

	public void setGuesses(GameNumber guesses) {
		this.guesses = guesses;
	}

	public GameNumber getTarget() {
		return target;
	}

	public void setTarget(GameNumber target) {
		this.target = target;
	}

	public GameMessage getMsg() {
		return msg;
	}

	public void setMsg(GameMessage msg) {
		this.msg = msg;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
