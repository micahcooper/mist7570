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
	int maximum, minimum;
	
	public GameLogic(){
		msg = new GameMessage();
		target = new GameNumber();
		System.out.println("New game logic started");
	}
	
	public GameLogic(GameNumber target){
		msg = new GameMessage();
		System.out.println("HI with target and guess");
	}
	
	public GameLogic(int minimum, int maximum){
		this.maximum=minimum;
		this.maximum=maximum;
		msg = new GameMessage();
		target = new GameNumber();
		guesses = new GameNumber(1);
		target.setRandom(minimum, maximum);
		
		System.out.println("New game logic started with min/max");
	}
	
	public boolean checkGuess(GameNumber guess){
		System.out.println("Lets play a game (checkGuess), target:" + target.getValue()+", guesses: "+guesses.getValue() );
		// compare the guess with the target
		   if( guess.getValue() == target.getValue() ){
			   // winner
			   msg.setMessage("Correct! You got it in " + guesses.getValue() + " guesses.");
			   resetGame();
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
	private void resetGame(){
		System.out.println("Reset game min:"+minimum+" max:"+maximum);
		//reset the target, set guesses to 1, and newGame flag to true
		//target = new GameNumber();
		target.setRandom(minimum, maximum, "reset game");
		this.guesses.setValue(1);
		//newGame=true;
		//this.guess = new GameNumber();
		//System.out.println("here");
		//msg.setMessage("");
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
