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
	double average;

	/**
	 * 
	 */
	public GameAverage() {
		// TODO Auto-generated constructor stub
	}
	public GameAverage(GameNumber guesses) {
		System.out.println("New game average");
		numberOfTotalGuesses = guesses.getValue();
		numberOfGames = 1;
	}
	public void updateAverage(GameNumber guesses){
		System.out.println("Updating averages");
		numberOfTotalGuesses += guesses.getValue();
		numberOfGames++;
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
		this.numberOfGames = numberOfGames;
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
		this.numberOfTotalGuesses = nubmerOfTotalGuesses;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}

}
