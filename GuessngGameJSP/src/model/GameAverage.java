/**
 * 
 */
package model;

/**
 * @author mrcooper
 *
 */
public class GameAverage {
	int numberOfGames;
	int numberOfTotalGuesses;
	//private double average;

	/**
	 * 
	 */
	public GameAverage() {
		// TODO Auto-generated constructor stub
	}
	public GameAverage(GameNumber guesses) {
		
		//guesses are incremented in the wrong guess logic for gameLogic, so add one for recording a correct guess beyond a single guess
		numberOfTotalGuesses = guesses.getValue();
		numberOfGames = 1;
		System.out.println("!!NEW!! game average with: "+numberOfTotalGuesses);
	}
	public void updateAverage(GameNumber guesses){
		
		numberOfGames++;
		numberOfTotalGuesses += guesses.getValue();
		System.out.println("!!UPDATE!! total guesses to: "+numberOfTotalGuesses);
	}
	/**
	 * @return the numberOfGames
	 */
	public int getNumberOfGames() {
		return numberOfGames;
	}

	/**
	 * @param numberOfGames the numberOfGames to set
	 */
	public void setNumberOfGames(int numberOfGames) {
		//this.numberOfGames = numberOfGames;
	}

	/**
	 * @return the nubmerOfTotalGuesses
	 */
	public int getNumberOfTotalGuesses() {
		return numberOfTotalGuesses;
	}

	/**
	 * @param nubmerOfTotalGuesses the nubmerOfTotalGuesses to set
	 */
	public void setNumberOfTotalGuesses(int nubmerOfTotalGuesses) {
		//this.numberOfTotalGuesses = nubmerOfTotalGuesses;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		double average = (double)numberOfTotalGuesses / (double)numberOfGames;
		System.out.println("Returning average: "+average+" from guesses: "+numberOfTotalGuesses+", games: "+numberOfGames);
		return average;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		//I should make sure this method make sense, don't want anyone to update the avearage.
		//this.average = average;
	}

}
